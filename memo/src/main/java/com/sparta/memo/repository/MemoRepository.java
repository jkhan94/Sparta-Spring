package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<"@Entity 클래스", "@Id 의 데이터 타입">
@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 수정 날짜를 기준으로 내림차순 정렬
    List<Memo> findAllByOrderByModifiedAtDesc();

    // username이 작성한 모든 메모를 불러옴
//    List<Memo> findAllByUsername(String username);
}
