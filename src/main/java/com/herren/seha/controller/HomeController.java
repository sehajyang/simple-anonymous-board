package com.herren.seha.controller;

import com.herren.seha.models.boards.Boards;
import com.herren.seha.models.boards.BoardsRepository;
import com.herren.seha.models.boards.BoardsSaveRequestDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@Log4j2
public class HomeController {

    @Autowired
    private BoardsRepository boardsRepository;

    @GetMapping("/")
    public String getHomePage(){
        return "main";
    }

    @PostMapping("/boards")
    public Boards saveBoards(@RequestBody BoardsSaveRequestDto dto){
         dto.toEntity();
        return boardsRepository.save(dto.toEntity());
    }
}
