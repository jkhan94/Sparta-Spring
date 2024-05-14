package com.sparta.spring_prepare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api") // 중복 URL은 한번만 작성
public class MVCHelloController {
    // URL은 중복 가능. 그러나 메소드까지 같으면 에러. URL이 같으면 메소드는 달라야 함.
    @GetMapping("/hellomvc")
    @ResponseBody // 보통 리턴문에는 찾아야 할 html 파일명을 작성. 그러나 순수하게 데이터(여기선 문자열)전달 시 옆 어노테이션 사용.
    public String hello() {
        return "hello world mvc!"; // 보통 뷰 전달. resources/templates에서 해당 뷰(hello world.html)이 있는지 찾음.
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "GET method";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String post() {
        return "POST method";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT method";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method";
    }
}
