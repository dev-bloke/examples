package com.meridal.examples.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/swagger-ui/index.html";
    }
}
