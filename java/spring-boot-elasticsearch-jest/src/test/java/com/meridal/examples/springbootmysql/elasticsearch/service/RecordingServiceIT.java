package com.meridal.examples.springbootmysql.elasticsearch.service;

import java.util.ArrayList;
import java.util.List;

import com.meridal.examples.springbootmysql.elasticsearch.test.TestFramework;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import com.meridal.examples.springbootmysql.elasticsearch.domain.Recording;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RecordingServiceIT extends TestFramework {
    
    private static final String[] IDS = { "991", "992", "993" };
    private static final int COUNT = IDS.length;

    @Autowired
    private RecordingService service;

    @Test
    public void testCRUD() {
        Recording recording = this.createRecording("998");
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
    public void testFindWithNonExistentDocument() {
        Recording other = this.service.findRecording("1234");
        assertNull(other);
    }

    @Test
    public void testFindRecordingsWithIDs() {
        List<String> ids = new ArrayList<>();
        List<Recording> recordings = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            Recording recording = this.randomRecording(IDS[i]);
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
            Recording recording = this.randomRecording(IDS[i]);
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
