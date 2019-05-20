package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import com.herren.seha.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author seha
 * @date 2019-05-15
 */

@Controller
@AllArgsConstructor
@Log4j2
public class AnonyBoardController {

    private BoardService boardService;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/lobby")
    public String lobbyPage(Model model) {
        List<BoardsMainResponseDto> boardList = boardService.getAnonyBoardsLists();
        model.addAttribute("boardList", CommonUtil.makeLimitList(boardList, 10));
        model.addAttribute("boardListLimit", CommonUtil.makeLimitList(boardList, 5));
        return "lobby";
    }

    @GetMapping("/boards/anony")
    public String getAnonyBoardsListPage(Model model) {
        model.addAttribute("boardList", boardService.getAnonyBoardsLists());
        return "anony/boardList";
    }

    @GetMapping("/boards/anony/{boardNo}")
    public String getAnonyBoardsDetail(@PathVariable("boardNo") Long boardNo, Model model) {
        log.debug("======================" + boardNo);
        model.addAttribute("boardDetail", boardService.getAnonyBoardsDetail(boardNo));
        return "anony/boardDetail";
    }

    @GetMapping("/boards/anony/editor")
    public String getAnonyBoardsEditor() {
        return "anony/editor";
    }

    @PostMapping("boards/anony/{boardNo}")
    public String modAnonyBoards(@PathVariable("boardNo") Long boardNo, @RequestBody BoardsSaveRequestDto dto) {
        int result = boardService.modAnonyBoards(boardNo, dto.getTitle(), dto.getContent());
        return "redirect:/boards/anony" + boardNo;
    }


}