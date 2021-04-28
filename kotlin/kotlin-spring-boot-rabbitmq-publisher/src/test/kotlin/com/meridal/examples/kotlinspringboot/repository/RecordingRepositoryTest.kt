package com.meridal.examples.kotlinspringboot.repository

import com.meridal.examples.kotlinspringbootamqp.repository.RecordingRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RecordingRepositoryTest
    @Autowired constructor(
    val entityManager: TestEntityManager,
    val repository: RecordingRepository
    ) {

    @Test
    fun `find by ID returns a Recording`() {
        val recording = Recording("David Bowie", "Lodger", "BOWLP1")
        val id = saveRecording(recording)
        val found = repository.findById(id)
        assert(found.isPresent)
        assertThat(found.get()).isEqualTo(recording)
    }

    @Test
    fun `find all returns everything in the repository`() {
        var recording = Recording("David Bowie", "Scary Monsters", "BOWLP2")
        saveRecording(recording)
        recording = Recording("Genesis", "We Can't Dance", "GENLP4")
        saveRecording(recording)
        val found = repository.findAll()
        assertThat(found.count()).isEqualTo(2)
    }

    @Test
    fun `Save persists a recording`() {
        val recording = Recording("Genesis", "Three Sides Live", "GENLP1")
        val saved = repository.save(recording)
        val id = saved.id!!
        val found = entityManager.find(Recording::class.java, id)
        assertThat(found).isEqualTo(recording)
    }

    @Test
    fun `Delete by ID removes a recording`() {
        val recording = Recording("King Crimson", "Discipline", "KCSP8")
        val id = saveRecording(recording)
        repository.deleteById(id)
        val other = entityManager.find(Recording::class.java, id)
        assert(other == null)
    }

    @Test
    fun `Delete removes a recording`() {
        val recording = Recording("The Beatles", "Abbey Road", "PCS 7088")
        val id = saveRecording(recording)
        repository.delete(recording)
        val other = entityManager.find(Recording::class.java, id)
        assert(other == null)
    }

    private fun saveRecording(recording: Recording): Long {
        val saved = entityManager.persist(recording)
        entityManager.flush()
        return saved.id!!
    }
}