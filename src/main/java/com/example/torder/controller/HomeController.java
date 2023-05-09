package com.example.torder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
            AlertUtils.alertAndMovePage(response, "아이디, 비밀번호가 일치하지 않습니다.", "/");
            return "redirect:/";
        }
    }

    /* 이전 페이지 이동 <보류 코드> */
    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    public String rateHandler(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    /* ID 생성 및 중복확인 */
    @PostMapping("/login/id/new")
    public String createID(NewLoginForm form) {
        member.setId(form.getId());
        memberService.join(member);
        return "redirect:/login/id/new";
    }

    /* ID 생성가능여부 판단 */
    @GetMapping("login/id/new")
    public void createIDHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (member.getId().equals("")) {
            AlertUtils.alertAndBackPage(response, "이미 존재하는 아이디입니다.");
        } else {
            AlertUtils.alertAndBackPage(response, "사용 가능한 아이디입니다.");
        }
    }

    /* PW 생성 및 일치 판단여부 */
    @PostMapping("/login/pw/new")
    public void createPW(NewLoginForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println();
        System.out.println("새로운 pw을 입력!!!");
        if (form.getPswd1().equals(form.getPswd2())) {
            member.setPassword(form.getPswd2());
            AlertUtils.alertAndBackPage(response, "비밀번호가 일치합니다.");
        } else {
            AlertUtils.alertAndBackPage(response, "비밀번호가 일치하지 않습니다.");
        }
    }

    /* 닉네임 생성 및 중복확인 */
    @PostMapping("/login/nick/new")
    public String createNick(NewLoginForm form) {
        System.out.println();
        System.out.println("새로운 닉네임을 입력!!!");
        member.setNickname(form.getNickname());
        memberService.join(member);
        return "redirect:/login/nick/new";
    }

    /* 닉네임 생성가능여부 판단 */
    @GetMapping("login/nick/new")
    public void createNick(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (member.getNickname().equals("")) {
            model.addAttribute("nickdata", "이미 존재하는 닉네임입니다.");
            AlertUtils.alertAndBackPage(response, "이미 존재하는 닉네임입니다.");
        } else {
            model.addAttribute("nickdata", "사용 가능한 닉네임입니다.");
            AlertUtils.alertAndBackPage(response, "사용 가능한 닉네임입니다.");
        }
    }

    /* 회원 생성 */
    @PostMapping("/login/check/new")
    public String createMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (member.getId() != "" && member.getPassword() != "" && member.getNickname() != "") {
            memberService.save(member);
            AlertUtils.alertAndMovePage(response, member.getNickname() + "님 환영합니다.", "/");
            member.drop();
            return "redirect:/";
        } else {
            AlertUtils.alertAndBackPage(response, "회원정보를 모두 입력해주세요.");
            return null; // AlterUtils에서 이전 페이지로 반환하므로 null을 넣어도 상관x
        }
    }
}
