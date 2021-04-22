package com.meridal.examples.domain

import org.apache.commons.lang3.RandomStringUtils
import java.util.*

private val random = Random()

fun createRecording(id: String, artist: String?, title: String?, catalogueNumber: String?, year: Int?): Recording {
    val recording = Recording(id)
    recording.artist = artist
    recording.title = title
    recording.catalogueNumber = catalogueNumber
    recording.year = year
    return recording
}

fun createRecording(id: String, artist: String?, title: String?, catalogueNumber: String?, year: Int?, songs: List<Song>): Recording {
    val recording = createRecording(id, artist, title, catalogueNumber, year)
    recording.addSongs(songs)
    return recording
}

fun cloneRecording(id: String, recording: Recording): Recording {
    val clone = Recording(id)
    clone.artist = recording.artist
    clone.title = recording.title
    clone.year = recording.year
    clone.catalogueNumber = recording.catalogueNumber
    clone.addSongs(recording.songs)
    return clone
}

fun randomRecording(id: String): Recording {
    val recording = Recording(id)
    recording.artist = randomStringWithMaxLength(32)
    recording.title = randomStringWithMaxLength(64)
    recording.catalogueNumber = randomStringWithMaxLength(16)
    recording.year = 1965 + randomPositiveInteger(50)
    val tracks = randomPositiveInteger(20)
    for (i in 0 until tracks) {
        recording.addSong(randomSong())
    }
    return recording
}

fun createSong(title: String?, minutes: Int, seconds: Int): Song {
    val song = Song()
    song.title = title
    song.setDuration(minutes, seconds)
    return song
}

fun cloneSong(song: Song): Song {
    val clone = Song()
    clone.duration = song.duration
    clone.title = song.title
    return clone
}

fun randomSong(): Song {
    return createSong(randomStringWithMaxLength(64), randomPositiveInteger(20), randomPositiveInteger(59))
}

private fun randomPositiveInteger(max: Int): Int {
    return Math.floorMod(random.nextInt(), max - 1) + 1
}

private fun randomStringWithMaxLength(max: Int): String? {
    return RandomStringUtils.randomAlphanumeric(1, max)
}