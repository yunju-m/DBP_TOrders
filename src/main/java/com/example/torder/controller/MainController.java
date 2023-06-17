package com.example.torder.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.torder.domain.Content;
import com.example.torder.service.ContentService;

@Controller
public class MainController {
    MatchingForm matchingForm = new MatchingForm();
    Content content = new Content();
    private final ContentService contentService;

    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }

    // userid, contentid을 이용해서 matchingForm 정보 저장
    @PostMapping("/post/ids")
    public String idsInfo(@RequestBody Map<String, String> data) {
        System.out.println("**** 나 작동한다 *****");
        System.out.println(data.get("userid"));
        System.out.println(data.get("contentid"));
        matchingForm.setUserid(data.get("userid"));
        matchingForm.setContentid(data.get("contentid"));
        System.out.println("내 id들 잘 매칭되었나??\n memberForm 출력드가자~~~~~");
        System.out.println(matchingForm.getUserid());
        System.out.println(matchingForm.getContentid());
        return "redirect:/post/ids/info";
    }

    // matchingForm 정보 이용해서 해당 게시글 내용 추출
    @GetMapping("/post/ids/info")
    @ResponseBody
    public Content contentInfo() {
        System.out.println("그다음 단계 정보 추출이올시다~~");
        content = contentService.getContentInfo(matchingForm);
        return content;
    }

    // // 게시글 상세 페이지로 이동
    @GetMapping("/content")
    public String contentForm() {
        return "contentForm";
    }
}
