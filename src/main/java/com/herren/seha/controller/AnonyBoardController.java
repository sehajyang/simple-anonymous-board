package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.NoticeBoardsMainResponseDto;
import com.herren.seha.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
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
    public String lobbyPage(Model model, HttpSession session) {
        List<BoardsMainResponseDto> boardList = boardService.getAnonyBoardsLists();
        List<NoticeBoardsMainResponseDto> noticeBoardList = boardService.getNoticeBoardsLists();

        model.addAttribute("boardList", CommonUtil.makeLimitListForNotice(noticeBoardList, 10));
        model.addAttribute("boardListLimit", CommonUtil.makeLimitList(boardList, 5));
        model.addAttribute("ssId", session.getAttribute("ssId"));

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
    public String getAnonyBoardsEditorPage() {
        return "anony/editor";
    }

    @GetMapping("/boards/anony/{boardNo}/editor")
    public String getAnonyBoardsModEditorPage(@PathVariable("boardNo") Long boardNo, Model model){
        model.addAttribute("boardDetail", boardService.getAnonyBoardsDetail(boardNo));
        return "anony/modEditor";
    }

}
