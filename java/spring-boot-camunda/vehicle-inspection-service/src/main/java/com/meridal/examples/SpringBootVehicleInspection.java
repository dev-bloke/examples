package com.meridal.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Vehicle Inspection microservice application.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootVehicleInspection {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootVehicleInspection.class);

    public static void main(String[] args) {
        LOG.debug("Starting Spring Boot...");
        SpringApplication.run(SpringBootVehicleInspection.class, args);
        LOG.debug("Spring Boot startup complete.");
    }
}
