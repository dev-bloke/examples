package com.meridal.examples.springbootdynamo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootDynamoDB {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootDynamoDB.class);

	public static void main(String[] args) {
		LOG.info("Starting Spring Boot with DynamoDB support.");
		SpringApplication.run(SpringBootDynamoDB.class, args);
		LOG.info("Spring Boot startup complete.");
	}
}