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
        AlertUtils.alertAndBackPage(response);
    }

    /* PW 생성 및 일치 판단여부 */
    @PostMapping("/login/pw/new")
    public String createPW(NewLoginForm form) {
        if (form.getPswd1() == form.getPswd2()) {
            member.setPassword(form.getPswd2());
        }
        return "redirect:/login/pw/new";
    }

    @GetMapping("login/pw/new")
    @ResponseBody
    public String createPwHandler() {
        JSONObject jo = new JSONObject();
        jo.put("password", member.getPassword());
        return jo.toJSONString();
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
    public String createNickHandler() {
        JSONObject jo = new JSONObject();
        jo.put("nickname", member.getNickname());
        return jo.toJSONString();
    }

    /* 회원 생성 */
    @PostMapping("/login/check/new")
    public String createMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (member.getId() != "" && member.getPassword() != "" && member.getNickname() != "") {
            memberService.save(member);
            // AlertUtils.alertAndMovePage(response, member.getNickname() + "님 환영합니다.",
            // "/");
            member.drop();
            return "redirect:/";
        } else {
            // AlertUtils.alertAndBackPage(response, "회원정보를 모두 입력해주세요.");
            return null; // AlterUtils에서 이전 페이지로 반환하므로 null을 넣어도 상관x
        }
    }
}
