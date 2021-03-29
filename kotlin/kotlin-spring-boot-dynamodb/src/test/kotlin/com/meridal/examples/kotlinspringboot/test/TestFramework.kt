package com.meridal.examples.kotlinspringboot.test

import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.model.Song
import org.apache.commons.lang3.RandomStringUtils
import java.util.*

abstract class TestFramework {

    private val random = Random()

    protected fun randomRecording() = randomRecording(null)

    protected fun randomRecording(id: String?): Recording {
        val recording = Recording()
        recording.id = id
        recording.artist = randomStringWithMaxLength(32)
        recording.title = randomStringWithMaxLength(64)
        recording.catalogueNumber = randomStringWithMaxLength(16)
        recording.year = 1965 + randomPositiveInteger(50)
        val songs: MutableList<Song> = mutableListOf()
        for (i in 1..randomPositiveInteger(20)) songs += randomSong()
        recording.songs = songs
        return recording
    }

    protected fun cloneRecording(id: String?, recording: Recording): Recording {
        val clone = Recording()
        clone.id = id
        clone.artist = recording.artist
        clone.title = recording.title
        clone.catalogueNumber = recording.catalogueNumber
        clone.year = recording.year
        clone.songs = recording.songs
        return clone
    }

    protected fun randomSong(): Song {
        val song = Song()
        song.title = randomStringWithMaxLength(64)
        val minutes = randomPositiveInteger(22)
        val seconds = randomPositiveInteger(60) - 1
        song.duration = "$minutes:$seconds"
        return song
    }

    protected fun cloneSong(id: Long, song: Song): Song {
        val clone = Song()
        clone.title = song.title
        clone.duration = song.duration
        return clone
    }

    private fun randomPositiveInteger(max: Int) = Math.floorMod(random.nextInt(), max - 1)

    private fun randomStringWithMaxLength(max: Int) = RandomStringUtils.randomAlphanumeric(1, max)
}