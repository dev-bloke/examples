package com.meridal.examples.springbootmysql.elasticsearch.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.meridal.examples.springbootmysql.elasticsearch.domain.Recording;
import com.meridal.examples.springbootmysql.elasticsearch.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class RecordingService {

    @Autowired
    private RecordingRepository repository;

    /**
     * Delete a recording.
     * @param recording
     */
    public void deleteRecording(Recording recording) {
        this.repository.delete(recording);
    }

    /**
     * Find all recordings.
     * @return Full list of recordings
     */
    public List<Recording> findAllRecordings() {
        Iterable<Recording> recordings = this.repository.findAll();
        return Lists.newArrayList(recordings);
    }

    /**
     * Find a recording by ID.
     * @param id ID
     * @return Recording
     */
    public Recording findRecording(String id) {
        return this.repository.findById(id).orElse(null);	
    }

    /**
     * Find all recordings matching the collection of IDs supplied.
     * @param ids IDs
     * @return List of recordings
     */
    public List<Recording> findRecordings(Collection<String> ids) {
        List<Recording> recordings = new ArrayList<>();
        for (String id : ids) {
            Optional<Recording> recording = this.repository.findById(id);
            if (recording.isPresent()) {
                recordings.add(recording.get());
            }
        }
        return recordings;
    }

    /**
     * Save a recording.
     * @param recording Recording
     */
    public void saveRecording(Recording recording) {
        this.repository.save(recording);
    }
}
