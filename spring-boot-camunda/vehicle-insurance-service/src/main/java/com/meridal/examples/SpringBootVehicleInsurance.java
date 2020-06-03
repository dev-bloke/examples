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
public class SpringBootVehicleInsurance {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootVehicleInsurance.class);

    public static void main(String[] args) {
        LOG.debug("Starting Spring Boot...");
        SpringApplication.run(SpringBootVehicleInsurance.class, args);
        LOG.debug("Spring Boot startup complete.");
    }
}
