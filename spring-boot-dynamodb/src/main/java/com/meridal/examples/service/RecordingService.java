package com.meridal.examples.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.meridal.examples.domain.Recording;
import com.meridal.examples.repository.RecordingRepository;

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
	    Iterable<Recording> recordings = this.repository.findAllById(ids);
	    return Lists.newArrayList(recordings);
    }
    
    /**
     * Save a recording.
     * @param recording Recording
     */
    public void saveRecording(Recording recording) {
	    this.repository.save(recording);
    }
}
