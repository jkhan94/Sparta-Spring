package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // 디비에 요청 DTO를 변환한 엔티티 memo 전달
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(saveMemo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoRepository.findAllByOrderByModifiedAtDesc().stream().map(MemoResponseDto::new).toList();
    }

    // 변경 감지를 확인하기 위해 어노테이션 추가
    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        // Optional은 null 체크해야 함.;
        Memo memo = findMemo(id);
        // memo 내용 수정 - 변경감지로 처리.
        memo.update(requestDto);
        return id;
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        // memo 삭제
        memoRepository.delete(memo);
        return id;
    }

    private Memo findMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
    }

    public List<MemoResponseDto> getMemosByKeyword(String keyword) {
        return memoRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(MemoResponseDto::new).toList();
    }
}
