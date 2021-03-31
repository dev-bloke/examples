package com.meridal.examples.kotlinspringboot.service

import io.mockk.*
import org.junit.jupiter.api.Assertions.*

import com.meridal.examples.kotlinspringboot.repository.RecordingRepository
import com.meridal.examples.kotlinspringboot.test.TestFramework
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class RecordingServiceTest(): TestFramework() {

    private val ID = "1234"
    private val OTHER_ID = "5678"

    private lateinit var repository: RecordingRepository
    private lateinit var service: RecordingService

    private val recording = randomRecording(ID)
    private val other = randomRecording(OTHER_ID)
    private val recordings = listOf(recording, other)
    private val ids = listOf(ID, OTHER_ID)

    @BeforeEach
    fun setup() {
        repository = mockk<RecordingRepository>()
        service = RecordingService(repository)
    }

    @Test
    fun `Get All Recordings retrieves all of the Recordings in the repository`() {
        every { repository.findAll() } returns recordings
        val found = service.getAllRecordings()
        assertTrue(found.contains(recording))
        assertTrue(found.contains(other))
    }

    @Test
    fun `Get Recording retrieves a Recording based on ID`() {
        every { repository.findById(ID) } returns Optional.of(recording)
        val found = service.getRecording(ID)
        assertEquals(recording, found)
    }

    @Test
    fun `Get Recording with an invalid ID returns null`() {
        every { repository.findById(ID) } returns Optional.empty()
        val found = service.getRecording(ID)
        assertNull(found)
    }

    @Test
    fun `Save Recording persists a Recording`() {
        every { repository.save(recording) } returns recording
        val saved = this.service.saveRecording(recording)
        assertEquals(recording, saved)
    }

    @Test
    fun `Delete Recording removes a Recording from the repository`() {
        every { repository.findById(ID) } returns Optional.of(recording)
        every { repository.deleteById(ID) } just Runs
        val deleted = service.deleteRecording(ID)
        assertEquals(recording, deleted)
        verify (exactly = 1) { repository.deleteById(ID) }
    }

    @Test
    fun `Delete Recording with an invalid ID returns null`() {
        every { repository.findById(ID) } returns Optional.empty()
        val deleted = service.deleteRecording(ID)
        assertNull(deleted)
        verify (exactly = 0) { repository.deleteById(ID) }
    }
}