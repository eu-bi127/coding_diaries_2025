package com.cal.controller;

import com.cal.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @DeleteMapping("/delete")
    public void deleteBoard(@RequestParam int id) throws Exception {
        boardService.deleteBoard(id);
    }
}
