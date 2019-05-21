package com.herren.seha.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author seha
 * @date 2019-05-21
 */

@Controller
@Log4j2
public class EtcPageController {
    @GetMapping("/patchnote")
    public String patchNotePage() {
        return "etc/patchNote";
    }

    @GetMapping("/dev/request")
    public String devRequestPage(Model model, HttpSession session) {

        return "etc/devRequest";
    }
}
