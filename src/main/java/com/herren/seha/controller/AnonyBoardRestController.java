package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsLike;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import com.herren.seha.util.CommonUtil;
import com.herren.seha.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping("/boards/anony/{boardNo}")
    public Long modAnonyBoards(@PathVariable("boardNo") Long boardNo, @RequestBody BoardsSaveRequestDto dto) {
        int result = boardService.modAnonyBoards(boardNo, dto.getTitle(), dto.getContent(), dto.getPasswd(), dto.getCategory(), dto.getSendyn());
        return (long) result;
    }

    @PostMapping("/boards/anony/{boardNo}/checkpwd")
    public Long getBoardsCheckPasswd(@PathVariable("boardNo") Long boardNo, String passwd) {
        String getDbPasswd = boardService.getBoardsCheckPasswd(boardNo, passwd);
        if (passwd != null) {
            if (passwd.equals(getDbPasswd)) {
                return 1L;
            }
        }
        return 0L;
    }


    //WANT FIX
    @PostMapping("/boards/anony/{boardNo}/like")
    public int doBoardsLikeCheckAndCountPlus(@PathVariable("boardNo") Long boardNo, Long userNo) {
        AnonyBoardsLike likeCheckYn = boardService.findByBoardNoAndUserNo(boardNo, userNo);
        if(likeCheckYn == null){

            boardService.doBoardsLikeCountPlus(boardNo, userNo);

            AnonyBoards anonyBoards = boardService.getAnonyBoardsDetail(boardNo);
            int nowLikeCount = boardService.getBoardsNowLikeCount(boardNo);
            SendSlackAndRegSendYnN(anonyBoards, nowLikeCount);
        }else {
            return 0;
        }
        return boardService.getBoardsNowLikeCount(boardNo);
    }

    @Transactional
    public void SendSlackAndRegSendYnN(AnonyBoards anonyBoards, int nowLikeCount) {
        if (nowLikeCount >= 20 && "발송대기".equals(anonyBoards.getSendyn())) {
            CommonUtil.sendSlack("http://192.168.0.77:4000/boards/anony/" + anonyBoards.getBoardNo());
            boardService.modAnonyBoardsSetSendYn(anonyBoards.getBoardNo(), "발송완료");
        }
    }
}
