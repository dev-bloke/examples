package com.meridal.examples.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import com.meridal.examples.domain.Recording;
import com.meridal.examples.test.TestFramework;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RecordingRepositoryIT extends TestFramework {

    @Autowired
    private RecordingRepository repository;

    @Test
    public void testCRUD() {
        Recording recording = this.createRecording();
        this.repository.save(recording);
        String id = recording.getId();
        assertNotNull(id);
        Recording other = this.repository.findById(id).orElse(null);
        this.checkRecording(other, WRONG_YEAR);
        recording.setYear(YEAR);
        this.repository.save(recording);
        other = this.repository.findById(id).orElse(null);
        this.checkRecording(other, YEAR);
        this.repository.delete(recording);
        other = this.repository.findById(id).orElse(null);
        assertNull(other);
    }
}
