package com.meridal.examples.springbootmysql;

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
public class SpringBootKafkaPublisherInitializer extends SpringBootServletInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootKafkaPublisherInitializer.class);
	}  	
}
