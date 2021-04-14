package com.meridal.examples.springbootamqp.repository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class RecordingRepository {

    @Value("${messaging.queue}")
    private String queueName;

    private final RabbitTemplate template;

    public RecordingRepository(@Autowired RabbitTemplate template) {
        this.template = template;
    }

    public void publish(String message) {
        this.template.convertAndSend(this.queueName, message);
    }
}
