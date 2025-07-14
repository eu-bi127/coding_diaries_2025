package com.cal.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void delete(int id);  // 삭제 기능
    // 추후 insert, update, select 등도 추가 가능
}
