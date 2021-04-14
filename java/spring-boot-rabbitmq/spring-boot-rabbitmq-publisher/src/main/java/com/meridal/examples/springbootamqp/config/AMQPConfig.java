package com.meridal.examples.springbootamqp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AMQPConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AMQPConfig.class);

    @Value("${messaging.queue}")
    private String queueName;

    @PostConstruct
    public void setup() {
        LOG.info("messaging.queue=" + this.queueName);
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queueName, false);
    }
}
