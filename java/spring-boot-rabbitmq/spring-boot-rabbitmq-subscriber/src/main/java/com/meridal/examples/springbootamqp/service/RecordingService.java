package com.meridal.examples.springbootamqp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordingService {

    private static final Logger LOG = LoggerFactory.getLogger(RecordingService.class);

    private final List<String> recordings = new ArrayList<>();

    public List<String> getAllRecordings() {
        return recordings;
    }

    @RabbitListener(queues = "${messaging.queue}")
    public void saveRecording(String message) {
        this.recordings.add(message);
        LOG.info("Received message: " + message);
    }
}
