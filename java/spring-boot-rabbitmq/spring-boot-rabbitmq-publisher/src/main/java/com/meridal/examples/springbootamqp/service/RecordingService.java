package com.meridal.examples.springbootamqp.service;

import com.meridal.examples.springbootamqp.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingService {

    private final RecordingRepository repository;

    public RecordingService(@Autowired RecordingRepository repository) {
        this.repository = repository;
    }

    public void publishRecording(final String message) {
        this.repository.publish(message);
    }
}
