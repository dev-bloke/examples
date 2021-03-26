package com.meridal.examples.springbootmysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFreemarker {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootFreemarker.class);

    public static void main(String[] args) {
        LOG.debug("Starting Spring Boot...");
        SpringApplication.run(SpringBootFreemarker.class, args);
        LOG.debug("Spring Boot startup complete.");
    }
}
