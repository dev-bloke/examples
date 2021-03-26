package com.meridal.examples.springbootmysql.springboot.service;

import com.google.common.collect.Lists;
import com.meridal.examples.springbootmysql.springboot.model.Recording;
import com.meridal.examples.springbootmysql.springboot.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordingService {

    private RecordingRepository repository;

    public RecordingService(@Autowired final RecordingRepository repository) {
        this.repository = repository;
    }

    public Recording getRecording(Long id) {
        Recording recording = null;
        final Optional found = this.repository.findById(id);
        if (found.isPresent()) {
            recording = (Recording) found.get();
        }
        return recording;
    }

    public List<Recording> getAllRecordings() {
        return Lists.newArrayList(this.repository.findAll());
    }

    public Recording saveRecording(Recording recording) {
        return this.repository.save(recording);
    }

    public Recording deleteRecording(Long id) {
        final Recording recording = this.getRecording(id);
        if (recording != null) {
            this.repository.deleteById(id);
        }
        return recording;
    }
}
