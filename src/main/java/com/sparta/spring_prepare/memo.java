package com.sparta.spring_prepare;

import lombok.Getter;
import lombok.Setter;

// 그래들이 빌드할 떄 자동으로 만들어줌.
@Getter
@Setter
public class Memo {
    private String username;
    private String contents;
}