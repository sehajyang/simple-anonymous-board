package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String getNoticeBoardsListPage(Model model) {
        model.addAttribute("boardList", boardService.getNoticeBoardsLists());
        return "notice/boardList";
    }

    @GetMapping("/boards/notice/{boardNo}")
    public String getNoticeBoardsDetail(@PathVariable("boardNo") Long boardNo, Model model) {
        return "notice/boardDetail";
    }

    @GetMapping("/boards/notice/editor")
    public String getNoticeBoardsEditor() {
        return "notice/editor";
    }

    @PostMapping("boards/notice/{boardNo}")
    public String modNoticeBoards(@PathVariable("boardNo") Long boardNo, @RequestBody BoardsSaveRequestDto dto) {
        int result = boardService.modAnonyBoards(boardNo, dto.getTitle(), dto.getContent());
        return "redirect:/boards/notice" + boardNo;
    }


}
