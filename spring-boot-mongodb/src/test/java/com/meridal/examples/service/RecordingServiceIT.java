package com.meridal.examples.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.meridal.examples.SpringBootMongoDB;
import com.meridal.examples.domain.Recording;
import com.meridal.examples.test.TestFramework;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootMongoDB.class)
@WebIntegrationTest
public class RecordingServiceIT extends TestFramework {
    
    private static final int COUNT = 3;

    @Autowired
    private RecordingService service;
    
    @Test
    public void testCRUD() {
	Recording recording = this.createRecording();
	this.service.saveRecording(recording);
	String id = recording.getId();
	assertNotNull(id);
	Recording other = this.service.findRecording(id);
	this.checkRecording(other, WRONG_YEAR);
	recording.setYear(YEAR);
	this.service.saveRecording(recording);
	other = this.service.findRecording(id);
	this.checkRecording(other, YEAR);
	this.service.deleteRecording(recording);
	other = this.service.findRecording(id);
	assertNull(other);
    }
    
    @Test
    public void testFindRecordingsWithIDs() {
	List<String> ids = new ArrayList<>();
	List<Recording> recordings = new ArrayList<>();
	for (int i = 0; i < COUNT; i++) {
	    Recording recording = this.randomRecording();
	    this.service.saveRecording(recording);
	    ids.add(recording.getId());
	    recordings.add(recording);
	}
	List<Recording> found = this.service.findRecordings(ids);
	assertEquals(COUNT, found.size());
	ids.remove(COUNT - 1);
	found = this.service.findRecordings(ids);
	assertEquals(COUNT - 1, found.size());
	ids.add(RandomStringUtils.randomAlphanumeric(8));
	found = this.service.findRecordings(ids);
	assertEquals(COUNT - 1, found.size());
	for (int i = 0; i < COUNT; i++) {
	    this.service.deleteRecording(recordings.get(i));
	}
	found = this.service.findRecordings(ids);
	assertTrue(found.isEmpty());
    }
    
    @Test
    public void testFindAllRecordings() {
	List<String> ids = new ArrayList<>();
	List<Recording> recordings = new ArrayList<>();
	for (int i = 0; i < COUNT; i++) {
	    Recording recording = this.randomRecording();
	    this.service.saveRecording(recording);
	    ids.add(recording.getId());
	    recordings.add(recording);
	}
	List<Recording> found = this.service.findAllRecordings();
	assertTrue(found.size() >= COUNT);
	for (int i = 0; i < COUNT; i++) {
	    this.service.deleteRecording(recordings.get(i));
	}
    }
}
