package com.cal.controller;

import com.cal.dto.BoardDto;
import com.cal.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Log4j
@RestController
@RequestMapping("/board") 
public class BoardController {

    private BoardService boardService;

    // ✅ 게시글 삭제
    @DeleteMapping("/delete")
    public void deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
    }

    // ✅ 게시글 목록 조회 (React와 연동될 API)
    @GetMapping("/list")
    public List<BoardDto> getBoardList() {
    	List<BoardDto> list = boardService.getBoardList();
    	log.info(list);
    	
        return list;  // 이 메서드를 서비스, 매퍼에 추가해줘야 함
    }
}
