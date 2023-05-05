package com.example.torder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.torder.domain.Member;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login/new")
    public String loginForm() {
        return "logForm";
    }

    @PostMapping("/login/new")
    public String create(LoginForm form) {
        System.out.println("id 를 입력합니다");
        System.out.println("id 입력값= " + form.getId());
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setNickname(form.getNickname());
        member.setUser_state(false);
        System.out.println("member.id= " + member.getId());
        System.out.println("member.password= " + member.getPassword());
        return "redirect:/";
    }
}
