package com.meridal.examples.springboot.service;

import com.meridal.examples.springboot.model.Recording;
import com.meridal.examples.springboot.repository.RecordingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecordingServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecordingRepository repository;

    private RecordingService service;

    private Recording bowie;
    private Recording genesis;

    @BeforeEach
    public void setup() {
        this.service = new RecordingService(this.repository);
        this.bowie = new Recording("David Bowie", "Lodger", "BOWLP1");
        this.genesis = new Recording("Genesis", "Three Sides Live", "GENLP1");
    }

    @Test
    public void testGetRecording() {
        final Long id = this.saveRecording(bowie);
        this.bowie.setId(id);
        final Recording recording = this.service.getRecording(id);
        assertEquals(bowie, recording);
    }

    @Test
    public void testGetAllRecordings() {
        final Long bowieId = this.saveRecording(bowie);
        this.bowie.setId(bowieId);
        final Long genesisId = this.saveRecording(genesis);
        this.genesis.setId(genesisId);
        final List<Recording> found = this.service.getAllRecordings();
        assertTrue(found.contains(bowie));
        assertTrue(found.contains(genesis));
    }

    @Test
    public void testSaveRecording() {
        final Recording recording = this.service.saveRecording(bowie);
        final Recording found = this.entityManager.find(Recording.class, recording.getId());
        assertEquals(recording, found);
    }

    @Test
    public void testDeleteRecording() {
        final Long bowieId = this.saveRecording(bowie);
        final Long genesisId = this.saveRecording(genesis);
        this.genesis.setId(genesisId);
        this.service.deleteRecording(bowieId);
        final Recording deleted = this.entityManager.find(Recording.class, bowieId);
        assertNull(deleted);
        final Recording found = this.entityManager.find(Recording.class, genesisId);
        assertEquals(genesis, found);
    }

    private Long saveRecording(final Recording recording) {
        final Recording saved = this.entityManager.persist(recording);
        this.entityManager.flush();
        return saved.getId();
    }
}
