package com.sparta.spring_prepare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    private static long visitCount = 0;

    // Cannot resolve MVC View 에러
    // templates 폴더에 있는 같은 이름의 html 파일 출력.
    // /만약 hello.html을 반환한다면 html/templates과 결과 동일
    @GetMapping("/static-hello")
    public String hello() {
        return "hello2.html";
    }

    // 정적 페이지를 컨트롤러를 통해 반환하는 경우
    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }

    // 동적 페이지 반환
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }

}
