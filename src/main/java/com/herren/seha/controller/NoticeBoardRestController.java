package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.NoticeBoardsSaveRequestDto;
import com.herren.seha.util.CommonUtil;
import com.herren.seha.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@AllArgsConstructor
@Log4j2
public class NoticeBoardRestController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/boards/notice/")
    public Long regNoticeBoards(@RequestBody NoticeBoardsSaveRequestDto dto, HttpSession session) {
        if(!CommonUtil.checkGradeAndRedirect(session)){
            return 0L;
        }
        return boardService.regNoticeBoards(dto);
    }

    @PostMapping("boards/notice/{boardNo}/delete")
    public String delNoticeBoards(@PathVariable("boardNo") Long boardNo, HttpSession session) {
        if(!CommonUtil.checkGradeAndRedirect(session)){
            return Constant.RESULT_FAIL;
        }

        int result = boardService.delNoticeBoards(boardNo);
        return (result > 0) ? Constant.RESULT_SUCCESS : Constant.RESULT_FAIL;
    }
}
