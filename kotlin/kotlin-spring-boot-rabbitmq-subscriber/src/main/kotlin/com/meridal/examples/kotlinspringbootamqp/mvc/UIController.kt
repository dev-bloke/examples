package com.meridal.examples.kotlinspringbootamqp.mvc

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UIController {

    @RequestMapping("/")
    fun redirect() = "redirect:/swagger-ui/index.html"
}