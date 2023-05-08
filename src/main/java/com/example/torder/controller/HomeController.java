package com.example.torder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.torder.domain.Member;
import com.example.torder.service.AlertUtils;
import com.example.torder.service.MemberService;

@Controller
public class HomeController {
    Member member = new Member();
    private final MemberService memberService;

    @Autowired
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login/new")
    public String loginForm() {
        return "logForm";
    }

    // 중복 로그인 발견
    @RequestMapping(value = "/login/alert", method = { RequestMethod.POST, RequestMethod.GET })
    public void sessionOver(HttpServletResponse response, HttpServletRequest request) throws Exception {
        AlertUtils.alertAndBackPage(response, "중복 회원 정보 입니다.");
    }

    /* ID 생성 및 중복확인 */
    @PostMapping("/login/id/new")
    public String createID(LoginForm form) {
        member.setId(form.getId());
        memberService.join(member);
        return "redirect:/login/id/new";
    }

    /* ID 생성가능여부 판단 */
    @GetMapping("login/id/new")
    public String createID(Model model) {
        if (member.getId().equals("")) {
            model.addAttribute("iddata", "이미 존재하는 아이디입니다.");
        } else {
            model.addAttribute("iddata", "사용 가능한 아이디입니다.");
        }
        return "logForm";
    }

    /* PW 생성 및 일치 판단여부 */
    @PostMapping("/login/pw/new")
    public String createPW(LoginForm form, Model model) {
        System.out.println();
        System.out.println("새로운 pw을 입력!!!");
        if (form.getPswd1().equals(form.getPswd2())) {
            member.setPassword(form.getPswd2());
            model.addAttribute("pwdata", "비밀번호가 일치합니다.");
        } else {
            model.addAttribute("pwdata", "비밀번호가 일치하지않습니다.");
        }
        return "logForm";
    }

    /* 닉네임 생성 및 중복확인 */
    @PostMapping("/login/nick/new")
    public String createNick(LoginForm form) {
        System.out.println();
        System.out.println("새로운 닉네임을 입력!!!");
        member.setNickname(form.getNickname());
        memberService.join(member);
        return "redirect:/login/nick/new";
    }

    /* 닉네임 생성가능여부 판단 */
    @GetMapping("login/nick/new")
    public String createNick(Model model) {
        if (member.getNickname().equals("")) {
            model.addAttribute("nickdata", "이미 존재하는 닉네임입니다.");
        } else {
            model.addAttribute("nickdata", "사용 가능한 닉네임입니다.");
        }
        return "logForm";
    }

    /* 회원 생성 */
    @PostMapping("/login/check/new")
    public String createMember(LoginForm form) {
        memberService.save(member);
        member.drop();
        return "redirect:/";
    }
}
