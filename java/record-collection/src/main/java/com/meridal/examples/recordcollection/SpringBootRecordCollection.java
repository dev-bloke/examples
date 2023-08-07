package com.meridal.examples.recordcollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootRecordCollection {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootRecordCollection.class);

	public static void main(String[] args) {
		LOG.info("Starting Twitter Proxy...");
		SpringApplication.run(SpringBootRecordCollection.class, args);
		LOG.info("...Spring Boot startup complete.");
	}
}