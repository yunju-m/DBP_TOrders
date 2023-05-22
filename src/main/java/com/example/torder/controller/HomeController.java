package com.example.torder.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.torder.domain.Member;
import com.example.torder.service.AlertUtils;
import com.example.torder.service.MemberService;

@Controller
public class HomeController {
    Member member = new Member();
    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login/new")
    public String loginForm() {
        memberService.existMembersave();
        return "logForm";
    }

    /* 로그인 ID 확인 */
    @PostMapping("/login")
    public String checkId(LoginForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        member.setId(form.getInput_id());
        member.setPassword(form.getInput_password());
        boolean login_check = memberService.Login(member);
        if (login_check) {
            return "main";
        } else {
            // AlertUtils.alertAndMovePage(response, "아이디, 비밀번호가 일치하지 않습니다.", "/");
            return "redirect:/";
        }
    }

    /* ID 생성 및 중복확인 */
    @PostMapping("/login/id/new")
    public String createID(NewLoginForm form) {
        member.setId(form.getId());
        memberService.join(member);
        System.out.println("나는 아이디 생성");
        return "redirect:/login/id/new";
    }

    /* ID 생성가능여부 판단 */
    @GetMapping("login/id/new")
    @ResponseBody
    public void createIDHandler(Model model, HttpServletResponse response) throws Exception {
        model.addAttribute("iddata", member.getId());
        System.out.println(member.getId());
        System.out.println("아이디 화면에 출력");
        AlertUtils.alertAndBackPage(response);
    }

    /* PW 생성 및 일치 판단여부 */
    @PostMapping("/login/pw/new")
    public void createPW(NewLoginForm form, Model model, HttpServletResponse response) throws Exception {
        if (form.getPswd1().equals(form.getPswd2())) {
            member.setPassword(form.getPswd2());
            System.out.println("비밀번호 저장!!");
        }
        AlertUtils.alertAndBackPage(response);
    }

    /* 닉네임 생성 및 중복확인 */
    @PostMapping("/login/nick/new")
    public String createNick(NewLoginForm form) {
        member.setNickname(form.getNickname());
        memberService.join(member);
        return "redirect:/login/nick/new";
    }

    /* 닉네임 생성가능여부 판단 */
    @GetMapping("login/nick/new")
    @ResponseBody
    public void createNickHandler(Model model, HttpServletResponse response) throws Exception {
        model.addAttribute("nickdata", member.getNickname());
        System.out.println("닉네임 화면에 출력");
        AlertUtils.alertAndBackPage(response);
    }

    /* 회원 생성 */
    @PostMapping("/login/check/new")
    public void createMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (member.getId() != "" && member.getPassword() != "" && member.getNickname() != "") {
            memberService.save(member);
            member.drop();
        } else {
            AlertUtils.alertAndBackPage(response);
        }
    }
}
