package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import com.herren.seha.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class AnonyBoardRestController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/boards/anony/")
    public Long regBoards(@RequestBody BoardsSaveRequestDto dto) {
        return boardService.regAnonyBoards(dto);
    }

    @PostMapping("boards/anony/{boardNo}/delete")
    public String delBoards(@PathVariable("boardNo") Long boardNo) {
        int result = boardService.delAnonyBoards(boardNo);
        return (result > 0) ? Constant.RESULT_SUCCESS : Constant.RESULT_FAIL;
    }
}
