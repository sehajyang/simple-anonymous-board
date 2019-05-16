package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
