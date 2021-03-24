package com.meridal.examples.kotlinspringboot.model

import com.meridal.examples.kotlinspringboot.test.TestFramework
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SongTest(): TestFramework() {

    private val ID = 1234L
    private val OTHER_ID = 5678L
    private val NOT_PERSISTED = 0L

    @Test
    fun `Songs with the same ID are equal and have the same hashCode`() {
        println("Same ID")
        val song = randomSong(ID)
        val other = cloneSong(ID, song)
        Assertions.assertEquals(song, other)
        Assertions.assertEquals(song.hashCode(), other.hashCode())
    }

    @Test
    fun `Songs with different IDs are not equal and do not have the same hashCode`() {
        val song = randomSong(ID)
        val other = cloneSong(OTHER_ID, song)
        Assertions.assertNotEquals(song, other)
        Assertions.assertNotEquals(song.hashCode(), other.hashCode())
    }

    @Test
    fun `Songs that have not been persisted are not equal`() {
        val song = randomSong(ID)
        val other = cloneSong(NOT_PERSISTED, song)
        val another = cloneSong(NOT_PERSISTED, song)
        Assertions.assertNotEquals(song, other)
        Assertions.assertNotEquals(other, another)
    }

    @Test
    fun `Songs are not equal to other types`() {
        val song = randomSong(ID)
        val list = listOf(1, 2, 3)
        Assertions.assertFalse(song == list)
    }

    @Test
    fun `A song is not equal to a null object`() {
        val song = randomSong(ID)
        val other: Song? = null
        Assertions.assertNotEquals(song, other)
    }
}