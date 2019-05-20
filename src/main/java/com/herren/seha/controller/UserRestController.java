package com.herren.seha.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@AllArgsConstructor
@Log4j2
public class UserRestController {

    @PostMapping("/login")
    public String loginPage(Model model) {

        return "user/login";
    }

    @PostMapping("/register")
    public String registerPage(Model model) {
        return "user/register";
    }

}
