package com.herren.seha.controller;

import com.herren.seha.domain.boards.BoardsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author seha
 * @date 2019-05-15
 */

@Controller
@AllArgsConstructor
@Log4j2
public class BoardController {

    @Autowired
    private BoardsRepository boardsRepository;

    @GetMapping("/")
    public String main(){
        return "main";
    }

}
