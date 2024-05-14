package com.sparta.spring_prepare.response;

import lombok.Getter;

@Getter
public class Star {
    // 필드는 key
    String name;
    int age;

    // key별 value 설정
    public Star(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Star() {
    }
}
