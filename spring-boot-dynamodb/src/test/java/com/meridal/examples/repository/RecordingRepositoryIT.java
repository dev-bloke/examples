package com.meridal.examples.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.meridal.examples.SpringBootDynamoDB;
import com.meridal.examples.domain.Recording;
import com.meridal.examples.test.TestFramework;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootDynamoDB.class)
@WebIntegrationTest
public class RecordingRepositoryIT extends TestFramework {
        
    @Autowired
    private RecordingRepository repository;
    
    @Test
    public void testCRUD() {
	Recording recording = this.createRecording();
	this.repository.save(recording);
	String id = recording.getId();
	assertNotNull(id);
	Recording other = this.repository.findOne(id);
	this.checkRecording(other, WRONG_YEAR);
	recording.setYear(YEAR);
	this.repository.save(recording);
	other = this.repository.findOne(id);
	this.checkRecording(other, YEAR);
	this.repository.delete(recording);
	other = this.repository.findOne(id);
	assertNull(other);
    }
}
