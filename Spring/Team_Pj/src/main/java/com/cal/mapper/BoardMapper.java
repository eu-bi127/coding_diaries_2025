package com.cal.mapper;

import com.cal.dto.BoardDto;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    // 게시글 전체(리스트)조회
    List<BoardDto> selectAll();

    // 게시글 삭제
    void delete(int id);
}
