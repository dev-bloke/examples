package com.meridal.examples.domain

import org.junit.Assert.*
import org.junit.Test

class RecordingFactoryTest {

    private val ARTIST = "Anne Artist"
    private val ID = "RECORDING-1"
    private val TITLE = "A Recording Title"
    private val CAT_NO = "CAT001"
    private val YEAR = 1965
    private val SONG_TITLE = "A Song Title"
    private val MINS = 5
    private val SECS = 17
    private val DURATION = "05:17"
    private val OTHER_ID = "RECORDING-2"

    @Test
    fun testCreateSong() {
        val song: Song = createSong(SONG_TITLE, MINS, SECS)
        validateSong(song)
    }

    @Test
    fun testRandomSong() {
        val song: Song = randomSong()
        validateRandomSong(song)
    }

    @Test
    fun testCreateRecordingWithSongs() {
        val song: Song = createSong(SONG_TITLE, MINS, SECS)
        val songs: MutableList<Song> = mutableListOf()
        songs.add(song)
        val recording: Recording = createRecording(ID, ARTIST, TITLE, CAT_NO, YEAR, songs)
        validateRecording(recording, ID, 1)
        validateSong(recording.songs[0])
    }

    @Test
    fun testCloneRecording() {
        val song: Song = createSong(SONG_TITLE, MINS, SECS)
        val songs: MutableList<Song> = mutableListOf()
        songs.add(song)
        val recording: Recording = createRecording(ID, ARTIST, TITLE, CAT_NO, YEAR, songs)
        val other: Recording = cloneRecording(OTHER_ID, recording)
        validateRecording(other, OTHER_ID, 1)
        validateSong(other.songs[0])
    }

    @Test
    fun testRandomRecordingWithID() {
        val recording: Recording = randomRecording(ID)
        validateRandomRecording(recording, ID)
    }

    private fun validateRecording(recording: Recording, id: String, numSongs: Int) {
        assertNotNull(recording.songs)
        assertEquals(numSongs, recording.songs.size)
        assertEquals(id, recording.id)
        assertEquals(ARTIST, recording.artist)
        assertEquals(TITLE, recording.title)
        assertEquals(CAT_NO, recording.catalogueNumber)
        assertEquals(YEAR, recording.year)
    }

    private fun validateRandomRecording(recording: Recording, id: String) {
        assertNotNull(recording.songs)
        assertTrue(recording.songs.size > 0)
        assertEquals(id, recording.id)
        assertNotNull(recording.artist)
        assertNotNull(recording.title)
        assertNotNull(recording.catalogueNumber)
        assertNotNull(recording.year)
    }

    private fun validateSong(song: Song) {
        assertEquals(SONG_TITLE, song.title)
        assertEquals(DURATION, song.duration)
    }

    private fun validateRandomSong(song: Song) {
        assertNotNull(song.title)
        assertNotNull(song.duration)
    }
}