package com.meridal.examples.springbootamqp.service;

import com.meridal.examples.springbootrabbitmq.domain.Recording;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordingService {

    private static final Logger LOG = LoggerFactory.getLogger(RecordingService.class);

    private final List<Recording> recordings = new ArrayList<>();

    public List<Recording> getAllRecordings() {
        return recordings;
    }

    @RabbitListener(queues = "${messaging.queue}")
    public void saveRecording(Recording recording) {
        this.recordings.add(recording);
        LOG.info("Received message: " + recording.toString());
    }
}
