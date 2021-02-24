package com.meridal.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootMySQL {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootMySQL.class);

	public static void main(String[] args) {
		LOG.info("Starting Spring Boot with MongoDB support.");
		SpringApplication.run(SpringBootMySQL.class, args);
		LOG.info("Spring Boot startup complete.");
	}
}