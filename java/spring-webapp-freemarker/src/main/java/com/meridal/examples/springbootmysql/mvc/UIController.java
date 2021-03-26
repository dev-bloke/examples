package com.meridal.examples.springbootmysql.mvc;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User Interface controller.
 * @author Martin Ingram
 */
@Controller
public class UIController {
    
    private static final Logger LOG = LoggerFactory.getLogger(UIController.class);
    
    private static final String FOO = "welcome.foo";
    private static final String BAR = "welcome.bar";
    
    private static final String FOO_KEY = "${" + FOO + "}";
    private static final String BAR_KEY = "${" + BAR + "}";
    
    @Value(FOO_KEY)
    private String foo;
    
    @Value(BAR_KEY)
    private String bar;
    
    /**
     * Display configuration at startup.
     */
    @PostConstruct
    public void config() {
        LOG.info("{}={}", FOO, this.foo);
        LOG.info("{}={}", BAR, this.bar);
    }

    /**
     * Welcome.
     * @return Welcome model and view
     */
    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("foo", foo);
        mav.addObject("bar", bar);
        return mav;
    }
}
