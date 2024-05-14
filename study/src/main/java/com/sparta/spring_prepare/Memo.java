package com.sparta.spring_prepare;

import lombok.*;

// 그래들이 빌드할 떄 자동으로 만들어줌.
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Memo {
    private String username;
    private String contents;
    private final String test;
}