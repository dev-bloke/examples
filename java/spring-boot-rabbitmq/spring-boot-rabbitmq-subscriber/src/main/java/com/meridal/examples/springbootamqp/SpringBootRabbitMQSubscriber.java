package com.meridal.examples.springbootamqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootRabbitMQSubscriber {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootRabbitMQSubscriber.class);

	public static void main(String[] args) {
		LOG.info("Starting Spring Boot with RabbitMQ subscription support.");
		SpringApplication.run(SpringBootRabbitMQSubscriber.class, args);
		LOG.info("Spring Boot startup complete.");
	}
}