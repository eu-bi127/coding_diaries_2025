package com.cal.service;

import com.cal.dto.BoardDto;
import com.cal.mapper.BoardMapper;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@AllArgsConstructor  //생성자 주입
@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> getBoardList() {
        return boardMapper.selectAll(); // Mapper에서 가져옴
    }

    @Override
    public void deleteBoard(int id) {
        boardMapper.delete(id);
    }
}
