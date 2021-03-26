package com.meridal.examples.springbootmysql.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for UI requests.
 * @author Martin Ingram
 */
@Controller
public class UIController {
	
    /**
     * Swagger redirect.
     * @return Swagger redirect
     */
    @RequestMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}
