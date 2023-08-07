package com.meridal.example.twitter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Servlet initializer for container-managed deployment.
 * @author Martin Ingram
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootTwitterProxyInitializer extends SpringBootServletInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootTwitterProxyInitializer.class);
	}  	
}
