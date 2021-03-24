package com.meridal.examples.kotlinspringboot.test

import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.model.Song
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.util.*

abstract class TestFramework {

    private val random = Random()

    protected fun randomRecording() = randomRecording(0L)

    protected fun randomRecording(id: Long): Recording {
        val artist = randomStringWithMaxLength(32)
        val title = randomStringWithMaxLength(64)
        val catalogueNumber = randomStringWithMaxLength(16)
        val year = 1965 + randomPositiveInteger(50)
        val songs: MutableList<Song> = mutableListOf()
        for (i in 1..randomPositiveInteger(20)) songs += randomSong()
        return Recording(artist, title, catalogueNumber, year, songs, id)
    }

    protected fun cloneRecording(id: Long, recording: Recording) =
        Recording(recording.artist, recording.title, recording.catalogueNumber, recording.year, recording.songs, id)

    protected fun randomSong() = randomSong(0L)

    protected fun randomSong(id: Long): Song {
        val title = randomStringWithMaxLength(64)
        val minutes = randomPositiveInteger(22)
        val seconds = randomPositiveInteger(60) - 1
        return Song(title, "$minutes:$seconds", id)
    }

    protected fun cloneSong(id: Long, song: Song) = Song(song.title, song.duration, id)

    protected fun saveRecording(recording: Recording, entityManager: TestEntityManager): Long {
        val saved = entityManager.persist(recording)
        entityManager.flush()
        return saved.id
    }

    private fun randomPositiveInteger(max: Int) = Math.floorMod(random.nextInt(), max - 1)

    private fun randomStringWithMaxLength(max: Int) = RandomStringUtils.randomAlphanumeric(1, max)
}