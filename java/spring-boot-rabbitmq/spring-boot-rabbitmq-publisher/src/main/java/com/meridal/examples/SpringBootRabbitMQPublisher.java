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
public class SpringBootRabbitMQPublisher {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootRabbitMQPublisher.class);

	public static void main(String[] args) {
		LOG.info("Starting Spring Boot with Kafka publishing support.");
		SpringApplication.run(SpringBootRabbitMQPublisher.class, args);
		LOG.info("Spring Boot startup complete.");
	}
}