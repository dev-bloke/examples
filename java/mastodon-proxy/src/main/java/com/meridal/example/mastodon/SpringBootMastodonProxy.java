package com.meridal.example.mastodon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application launcher.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootMastodonProxy {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringBootMastodonProxy.class);

	public static void main(String[] args) {
		LOG.info("Starting Twitter Proxy...");
		SpringApplication.run(SpringBootMastodonProxy.class, args);
		LOG.info("...Spring Boot startup complete.");
	}
}