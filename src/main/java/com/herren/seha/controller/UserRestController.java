package com.herren.seha.controller;

import com.herren.seha.biz.User.UserService;
import com.herren.seha.dto.user.UserSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seha
 * @date 2019-05-15
 */

@RestController
@AllArgsConstructor
@Log4j2
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginPage(Model model) {

        return "user/login";
    }

    @PostMapping("/register")
    public Long registerPage(@RequestBody UserSaveRequestDto dto) {
        dto.setGrade("사원");
        return userService.regUserData(dto);
    }

}
