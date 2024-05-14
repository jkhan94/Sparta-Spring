package com.sparta.spring_prepare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// API 1게.
@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "hello World!";
    }
}

