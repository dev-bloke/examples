package com.meridal.examples;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Web Initializer for container managed deployment (e.g. Tomcat).
 * @author Martin Ingram
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootVehicleTaxInitializer extends SpringBootServletInitializer {  
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootVehicleTaxInitializer.class);
    }    
}
