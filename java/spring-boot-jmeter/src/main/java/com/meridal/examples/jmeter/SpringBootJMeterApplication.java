package com.meridal.examples.jmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MQTT Solid Bridge application entry point.
 * @author Martin Ingram
 */
@SpringBootApplication
public class SpringBootJMeterApplication {

    /**
     * Run the server.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJMeterApplication.class, args);
    }
}