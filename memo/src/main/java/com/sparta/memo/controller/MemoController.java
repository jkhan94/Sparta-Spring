package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {
    // 디비 대신 임시로 사용
    private final Map<Long, Memo> memoList = new HashMap<>();

    // 메모 생성 API
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // Memo의 max ID 중복체크
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // 디비 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto responseDto = new MemoResponseDto(memo);
        return responseDto;
    }

    // 메모 조회
    @GetMapping("/memos")
    public List<MemoResponseDto> getAllMemos() {
        // Map -> List
        List<MemoResponseDto> responseList = memoList.values()
                .stream() // memoList에서 하나씩 빼옴
                .map(MemoResponseDto::new) // 하나씩 뺴온 걸 MemoResponseDto 생성자를 통해 MemoResponseDto로 변환
                .toList(); // 변환된 MemoResponseDto를 리스트에 저장
        
        return responseList;
    }
}
