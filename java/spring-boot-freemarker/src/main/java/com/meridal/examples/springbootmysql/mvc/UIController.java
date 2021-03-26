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
    
    private static final String FOO = "foo";
    private static final String FOO_KEY = "${" + FOO + "}";
    private static final String BAR = "bar";
    private static final String BAR_KEY = "${" + BAR + "}";
    
    @Value(FOO_KEY)
    private String foo;
    
    @Value(BAR_KEY)
    private String bar;
    
    /**
     * Display imported values at startup.
     */
    @PostConstruct
    public void config() {
		LOG.info("{}={}", FOO, this.foo);
		LOG.info("{}={}", BAR, this.bar);
    }
    
    /**
     * Welcome (home page) endpoint.
     * @return Welcome model and view
     */
    @RequestMapping("/")
    public ModelAndView welcome() {
		LOG.debug("WELCOME request.");
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("foo", this.foo);
		mav.addObject("bar", this.bar);
		return mav;
    }
}
