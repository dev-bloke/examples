package com.meridal.examples.springbootmysql.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootElasticSearch {
    
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootElasticSearch.class);

    public static void main(String[] args) {
        LOG.info("Starting Spring Boot with ElasticSearch support.");
        SpringApplication.run(SpringBootElasticSearch.class, args);
        LOG.info("Spring Boot startup complete.");
    }
}
