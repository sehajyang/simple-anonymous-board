package com.herren.seha.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
    public String registerPage() {
        return "user/register";
    }

    @GetMapping("/forgetpass")
    public String forgetpassPage() {
        return "user/forget-pass";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.removeAttribute("ssId");
        session.invalidate();
        return "redirect:/";
    }

}
