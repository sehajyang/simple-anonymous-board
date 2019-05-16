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
public class BoardController {

    private BoardService boardService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("boardList", boardService.getBoardsList());
        return "main";
    }

    @GetMapping("/boards/{boardNo}")
    public String getBoards(@PathVariable("boardNo") Long boardNo, Model model) {
        log.debug("======================"+boardNo);
        model.addAttribute("boardDetail", boardService.getBoardsDetail(boardNo));
        return "boardDetail";
    }


    @PostMapping("boards/{boardNo}")
    public String modBoards(@PathVariable("boardNo") Long boardNo, @RequestBody BoardsSaveRequestDto dto){
        int result = boardService.modBoards(boardNo, dto.getTitle(), dto.getContent());
        return "redirect:/boards/"+boardNo;
    }

}
