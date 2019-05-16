package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@AllArgsConstructor
@Log4j2
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/boards")
    public Long regBoards(@RequestBody BoardsSaveRequestDto dto) {
        return boardService.regBoards(dto);
    }

//    @GetMapping("/boards/{boardNo}")
//    public Long getBoards(Integer boardNo) {
//        return boardService.modBoards(dto);
//    }
//
//    @PostMapping("boards/{boardNo}")
//    public String modBoards(@RequestBody BoardsSaveRequestDto dto, Integer boardNo){
//        int result = boardService.modBoards(dto);
//        return "";
//    }
}
