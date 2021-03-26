package com.meridal.examples.springbootmysql.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.Lists;
import com.meridal.examples.springbootmysql.springboot.model.Recording;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

/**
 * Unit tests for each of the methods in {@link RecordingRepository} that we rely on.
 */
@DataJpaTest
public class RecordingRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecordingRepository repository;

    private Recording bowie;
    private Recording genesis;

    @BeforeEach
    public void setup() {
        this.bowie = new Recording("David Bowie", "Lodger", "BOWLP1");
        this.genesis = new Recording("Genesis", "Three Sides Live", "GENLP1");
    }

    @Test
    public void testFindById() {
        final Long id = this.saveRecording(bowie);
        final Optional found = this.repository.findById(id);
        assertTrue(found.isPresent());
        assertEquals(bowie, found.get());
    }

    @Test
    public void testFindAll() {
        final Long bowieId = this.saveRecording(bowie);
        this.bowie.setId(bowieId);
        final Long genesisId = this.saveRecording(genesis);
        this.genesis.setId(genesisId);
        final List<Recording> found = Lists.newArrayList(this.repository.findAll());
        assertTrue(found.contains(bowie));
        assertTrue(found.contains(genesis));
    }

    @Test
    public void testSave() {
        final Recording recording = this.repository.save(bowie);
        final Recording found = this.entityManager.find(Recording.class, recording.getId());
        assertEquals(recording, found);
    }

    @Test
    public void testDelete() {
        final Long bowieId = this.saveRecording(bowie);
        final Long genesisId = this.saveRecording(genesis);
        this.genesis.setId(genesisId);
        this.repository.deleteById(bowieId);
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
