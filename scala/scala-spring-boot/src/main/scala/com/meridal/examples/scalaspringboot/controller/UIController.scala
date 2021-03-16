package com.meridal.examples.scalaspringboot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UIController {
  
  @RequestMapping(Array("/"))
  def redirect() = "redirect:/swagger-ui.html"
}
