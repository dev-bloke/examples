package com.meridal.examples.springbootmongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootMongoDB {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootMongoDB.class);

	public static void main(String[] args) {
		LOG.info("Starting Spring Boot with MongoDB support.");
		SpringApplication.run(SpringBootMongoDB.class, args);
		LOG.info("Spring Boot startup complete.");
	}
}