package com.example.torder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.torder.domain.Member;
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

    /* ID 생성 */
    @PostMapping("/login/id/new")
    public String createID(LoginForm form) {
        member.setId(form.getId());
        System.out.println(member.getId());
        memberService.join(member);
        return "logForm";
    }

    /* PW 생성 */
    @PostMapping("/login/pw/new")
    public String createPW(LoginForm form) {
        member.setPassword(form.getPswd2());
        System.out.println(member.getPassword());
        return "logForm";
    }

    /* 닉네임 생성 */
    @PostMapping("/login/nick/new")
    public String createNick(LoginForm form) {
        member.setNickname(form.getNickname());
        System.out.println(member.getNickname());
        memberService.join(member);
        return "logForm";
    }

    /* 회원 생성 */
    @PostMapping("/login/check/new")
    public String createMember(LoginForm form) {
        memberService.join(member);
        member.drop();
        return "redirect:/";
    }
}
