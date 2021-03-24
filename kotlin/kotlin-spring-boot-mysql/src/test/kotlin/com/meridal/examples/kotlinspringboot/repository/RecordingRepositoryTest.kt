package com.meridal.examples.kotlinspringboot.repository

import org.junit.jupiter.api.Assertions.*

import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.test.TestFramework
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

/**
 * Unit tests for all of the methods in {@link RecordingRepository} that we currently rely on.
 */
@DataJpaTest
class RecordingRepositoryTest
    @Autowired constructor(
    val entityManager: TestEntityManager,
    val repository: RecordingRepository): TestFramework() {

    private lateinit var recording: Recording
    private lateinit var other: Recording

    @BeforeEach
    fun setup() {
        recording = randomRecording()
        other = randomRecording()
        recording.id = saveRecording(recording)
        other.id = saveRecording(other)
    }

    @Test
    fun `Find All retrieves all Recordings that have been persisted`() {
        val found = repository.findAll().toList()
        assertTrue(found.contains(recording))
        assertTrue(found.contains(other))
    }

    @Test
    fun `Find By ID retrieves the relevant Recording`() {
        val found = repository.findById(recording.id)
        assertTrue(found.isPresent)
        assertEquals(recording, found.get())
    }

    @Test
    fun `Save persists a recording`() {
        val saved = repository.save(randomRecording())
        val found = entityManager.find(Recording::class.java, saved.id)
        assertEquals(saved, found)
    }

    @Test
    fun `Delete removes a recording`() {
        repository.deleteById(recording.id)
        val deleted = entityManager.find(Recording::class.java, recording.id)
        assertNull(deleted)
        val found = entityManager.find(Recording::class.java, other.id)
        assertEquals(other, found)
    }

    private fun saveRecording(recording: Recording) = saveRecording(recording, entityManager)
}