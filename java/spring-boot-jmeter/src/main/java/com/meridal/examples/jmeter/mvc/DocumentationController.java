package com.meridal.examples.jmeter.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Swagger online documentation controller.
 * @author Martin Ingram
 */
@Controller
public class DocumentationController {

    /**
     * Redirect to the default OpenAPI Swagger endpoint.
     * @return Swagger redirect
     */
    @RequestMapping("/")
    public final String redirect() {
        return "redirect:/swagger-ui.html";
    }
}