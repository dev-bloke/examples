package com.meridal.examples.springbootmongo.service;

import com.google.common.collect.Lists;
import com.meridal.examples.springbootmongo.domain.Recording;
import com.meridal.examples.springbootmongo.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class RecordingService {
   
    private final RecordingRepository repository;

    public RecordingService(@Autowired RecordingRepository repository) {
        this.repository = repository;
    }
 
    /**
     * Delete a recording.
     * @param id ID
     */
    public Recording deleteRecording(final String id) {
	    final Recording recording = this.repository.findById(id).orElse(null);
	    if (recording != null) {
            this.repository.deleteById(id);
        }
	    return recording;
    }
    
    /**
     * Find all recordings.
     * @return Full list of recordings
     */
    public List<Recording> getAllRecordings() {
		return Lists.newArrayList(this.repository.findAll());
    }
    
    /**
     * Find a recording by ID.
     * @param id ID
     * @return Recording
     */
    public Recording getRecording(final String id) {
	    return this.repository.findById(id).orElse(null);	
    }
    
    /**
     * Find all recordings matching the collection of IDs supplied.
     * @param ids IDs
     * @return List of recordings
     */
    public List<Recording> getRecordings(final Collection<String> ids) {
		Iterable<Recording> recordings = this.repository.findAllById(ids);
		return Lists.newArrayList(recordings);
    }
    
    /**
     * Save a recording.
     * @param recording Recording
     */
    public Recording saveRecording(final Recording recording) {
	    return this.repository.save(recording);
    }
}
