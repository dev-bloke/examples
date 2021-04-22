package com.meridal.examples.domain

import org.junit.Assert.*
import org.junit.Test

class RecordingTest {

    private val ID = "1234"
    private val OTHER_ID = "5678"

    @Test
    fun testEqualsAndHashCodeWithSameID() {
        val recording = createRecording(ID)
        val other = createRecording(ID)
        assertEquals(recording, other)
        assertEquals(recording.hashCode(), other.hashCode())
    }

    @Test
    fun testEqualsAndHashCodeWithDifferentID() {
        val recording = createRecording(ID)
        val other = createRecording(OTHER_ID)
        assertNotEquals(recording, other)
        assertNotEquals(recording.hashCode(), other.hashCode())
    }

    @Test
    fun testEqualsWithAnotherType() {
        val recording = createRecording(ID)
        val other: List<Int> = ArrayList()
        assertNotEquals(recording, other)
    }

    @Test
    fun testEqualsWithNull() {
        val recording = createRecording(ID)
        assertNotEquals(recording, null)
    }

    private fun createRecording(id: String): Recording? {
        val recording = Recording(id)
        recording.title = "A Recording"
        recording.artist = "Anne Artist"
        recording.year = 1965
        recording.catalogueNumber = "CAT001"
        return recording
    }

    private fun createSong(index: Int): Song? {
        val song = Song()
        song.title = "A Song Title"
        song.setDuration(5, index)
        return song
    }

    private fun verifySong(song: Song, index: Int) {
        assertNotNull(song)
        assertEquals("A Song Title", song.title)
        assertEquals("05:0$index", song.duration)
    }
}