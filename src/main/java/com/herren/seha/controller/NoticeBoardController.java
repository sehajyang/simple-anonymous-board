package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.domain.boards.notice.NoticeBoards;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import com.herren.seha.util.CommonUtil;
import com.herren.seha.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author seha
 * @date 2019-05-15
 */

@Controller
@AllArgsConstructor
@Log4j2
public class NoticeBoardController {

    private BoardService boardService;

    @GetMapping("/boards/notice")
    public String getNoticeBoardsListPage(Model model, HttpSession session,
                                          @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        Page<NoticeBoards> boardList = boardService.getNoticeBoardsAllList(pageNo, Constant.boardListCountDefault);
        model.addAttribute("boardList", boardList.getContent());
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageLastNum", boardList.getTotalPages( ));
        log.error("asdfasdf"+boardList.getTotalPages());

        model.addAttribute("grade", session.getAttribute("grade"));

        return "notice/boardList";
    }

    @GetMapping("/boards/notice/{boardNo}")
    public String getNoticeBoardsDetail(@PathVariable("boardNo") Long boardNo, Model model) {
        model.addAttribute("boardDetail", boardService.getNoticeBoardsDetail(boardNo));
        return "notice/boardDetail";
    }

    @GetMapping("/boards/notice/editor")
    public String getNoticeBoardsEditor(HttpSession session) {
        if(!CommonUtil.checkGradeAndRedirect(session)){
            return "redirect:/lobby";
        }
        return "notice/editor";
    }

    @GetMapping("/boards/notice/{boardNo}/editor")
    public String getNoticeBoardsModEditorPage(@PathVariable("boardNo") Long boardNo, Model model){
        model.addAttribute("boardDetail", boardService.getNoticeBoardsDetail(boardNo));
        return "notice/modEditor";
    }

    @ResponseBody
    @PostMapping("boards/notice/{boardNo}")
    public Long modNoticeBoards(@PathVariable("boardNo") Long boardNo, @RequestBody BoardsSaveRequestDto dto,
                                  HttpSession session) {
        if(!CommonUtil.checkGradeAndRedirect(session)){
            return 0L;
        }
        int result = boardService.modNoticeBoards(boardNo, dto.getTitle(), dto.getContent());
        return (long) result;
    }


}
