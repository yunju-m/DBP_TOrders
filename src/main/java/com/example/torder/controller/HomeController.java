package com.example.torder.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.torder.domain.Member;
import com.example.torder.service.AlertUtils;
import com.example.torder.service.MemberService;

import ch.qos.logback.core.net.SyslogOutputStream;

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
        System.out.println(form.getInput_id() + " " + form.getInput_password());
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
    public String createID(@RequestBody Map<String, String> data) {
        member.setId(data.get("id"));
        memberService.join(member);
        return "redirect:/login/id/new";
    }

    /* ID 생성가능여부 판단 */
    @GetMapping("login/id/new")
    @ResponseBody
    public String createIDHandler() {
        if (member.getId().equals("")) {
            return "false";
        } else {
            return "true";
        }
    }

    /* PW 생성 여부 */
    @PostMapping("/login/pw/new")
    public String createPW(@RequestBody Map<String, String> data) {
        if (data.get("pwd1").equals(data.get("pwd2"))) {
            member.setPassword(data.get("pwd2"));
        } else {
            member.setPassword("");
        }
        return "redirect:/login/pw/new";
    }

    /* PW 일치 여부 반환 */
    @GetMapping("/login/pw/new")
    @ResponseBody
    public String createPWHandler() {
        if (member.getPassword().equals("")) {
            return "false";
        } else {
            return "true";
        }
    }

    /* 닉네임 생성 및 중복확인 */
    @PostMapping("/login/nick/new")
    public String createNick(@RequestBody Map<String, String> data) {
        member.setNickname(data.get("nickname"));
        memberService.join(member);
        return "redirect:/login/nick/new";
    }

    /* 닉네임 생성가능여부 판단 */
    @GetMapping("login/nick/new")
    @ResponseBody
    public String createNickHandler() {
        if (member.getNickname().equals("")) {
            return "false";
        } else {
            return "true";
        }
    }

    /* 회원 생성 */
    @GetMapping("/login/check/new")
    @ResponseBody
    public String createMember() {
        if (member.getId().equals("") ||
                member.getPassword().equals("") ||
                member.getNickname().equals("")) {
            memberService.save(member);
            return "false";
        } else {
            return "true";
        }
    }
}
