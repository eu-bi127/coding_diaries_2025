package com.cal.service;

import com.cal.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void deleteBoard(int id) throws Exception {
        boardMapper.delete(id);
    }
}
