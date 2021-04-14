package com.meridal.examples.springbootamqp.service;

import com.meridal.examples.springbootamqp.repository.RecordingRepository;
import com.meridal.examples.springbootrabbitmq.domain.Recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingService {

    private final RecordingRepository repository;

    public RecordingService(@Autowired RecordingRepository repository) {
        this.repository = repository;
    }

    public void publishRecording(final Recording recording) {
        this.repository.publish(recording);
    }
}
