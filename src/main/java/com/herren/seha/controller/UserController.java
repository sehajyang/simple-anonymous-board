package com.herren.seha.controller;

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
public class UserController {

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "user/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        return "user/register";
    }

    @GetMapping("/forgetpass")
    public String forgetpassPage(Model model) {
        return "user/forget-pass";
    }

    @GetMapping("/logout")
    public String doLogout(Model model) {
        return "redirect:/";
    }

}
