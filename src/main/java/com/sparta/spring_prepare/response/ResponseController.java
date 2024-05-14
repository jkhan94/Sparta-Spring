package com.sparta.spring_prepare.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

    // JSON -> String
    // Content-Type: text/html
    // text 형태로 출력(1줄): {"name":"Robbie", "age":95}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // JSON -> String
    // Content-Type: application/JSON
    // JSON 형태로 출력 (2줄)
    // {
    //    "name": "Robbie",
    //    "age": 95
    //}
    // 스프링에서 자바 객체를 JSON으로 변환해줌. 왜냐하면 자바스크립트는 자바 객체를 인식 못 하기 때문.
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}
