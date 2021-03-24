package com.meridal.examples.kotlinspringboot.model

import org.junit.jupiter.api.Assertions.*

import com.meridal.examples.kotlinspringboot.test.TestFramework
import org.junit.jupiter.api.Test

class RecordingTest(): TestFramework() {

    private val ID = 1234L
    private val OTHER_ID = 5678L
    private val NOT_PERSISTED = 0L;

    @Test
    fun `Recordings with the same ID are equal and have the same hashCode`() {
        val recording = randomRecording(ID)
        val other = cloneRecording(ID, recording)
        assertEquals(recording, other)
        assertEquals(recording.hashCode(), other.hashCode())
    }

    @Test
    fun `Recordings with different IDs are not equal and do not have the same hashCode`() {
        val recording = randomRecording(ID)
        val other = cloneRecording(OTHER_ID, recording)
        assertNotEquals(recording, other)
        assertNotEquals(recording.hashCode(), other.hashCode())
    }

    @Test
    fun `Recordings that have not been persisted are not equal`() {
        val recording = randomRecording(ID)
        val other = cloneRecording(NOT_PERSISTED, recording)
        val another = cloneRecording(NOT_PERSISTED, recording)
        assertNotEquals(recording, other)
        assertNotEquals(other, another)
    }

    @Test
    fun `Recordings are not equal to other types`() {
        val recording = randomRecording(ID)
        val list = listOf(1, 2, 3)
        assertFalse(recording == list)
    }

    @Test
    fun `A recording is not equal to a null object`() {
        val recording = randomRecording(ID)
        val other: Recording? = null
        assertNotEquals(recording, other)
    }
}