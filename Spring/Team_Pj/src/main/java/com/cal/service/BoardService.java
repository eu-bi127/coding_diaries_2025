package com.cal.service;

import com.cal.dto.BoardDto;
import java.util.List;

public interface BoardService {
    // 게시판 글 목록 조회 메서드 추가
    List<BoardDto> getBoardList();

    // 기존 게시글 삭제 메서드 유지
    void deleteBoard(int id);
}
