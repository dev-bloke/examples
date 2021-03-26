package com.meridal.examples.springbootmongo.repository;

import com.google.common.collect.Lists;
import com.meridal.examples.springbootmongo.domain.Recording;
import com.meridal.examples.springbootmongo.test.TestFramework;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for each of the methods in {@link RecordingRepository} that we rely on.
 */
@DataMongoTest
public class RecordingRepositoryTest extends TestFramework {

    @Autowired
    private MongoTemplate template;

    @Autowired
    private RecordingRepository repository;

    private Recording recording;
    private Recording otherRecording;

    @BeforeEach
    public void setup() {
        this.recording = this.randomRecording();
        this.otherRecording = this.randomRecording();
        final String id = this.saveRecording(this.recording);
        this.recording.setId(id);
        final String otherId = this.saveRecording(this.otherRecording);
        this.otherRecording.setId(otherId);
    }

    @Test
    public void testFindAll() {
        final List<Recording> found = Lists.newArrayList(this.repository.findAll());
        assertTrue(found.contains(recording));
        assertTrue(found.contains(otherRecording));
    }

    @Test
    public void testFindById() {
        final Optional found = this.repository.findById(this.recording.getId());
        assertTrue(found.isPresent());
        assertEquals(recording, found.get());
    }

    @Test
    public void testFindAllById() {
        this.repository.save(this.randomRecording());
        final List<String> ids = Arrays.asList(recording.getId(), otherRecording.getId());
        final List<Recording> found = Lists.newArrayList(this.repository.findAllById(ids));
        assertEquals(2, found.size());
        assertTrue(found.contains(recording));
        assertTrue(found.contains(otherRecording));
    }

    @Test
    public void testSave() {
        final Recording recording = this.repository.save(this.randomRecording());
        final Recording found = this.getRecording(recording.getId());
        assertEquals(recording, found);
    }

    @Test
    public void testDelete() {
        this.repository.deleteById(recording.getId());
        final Recording deleted = this.getRecording(recording.getId());
        assertNull(deleted);
        final Recording found = this.getRecording(otherRecording.getId());
        assertEquals(otherRecording, found);
    }

    private String saveRecording(final Recording recording) {
        return this.template.save(recording).getId();
    }

    private Recording getRecording(final String id) {
        return this.template.findById(id, Recording.class);
    }
}
