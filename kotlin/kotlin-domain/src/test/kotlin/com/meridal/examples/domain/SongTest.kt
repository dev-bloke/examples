package com.meridal.examples.domain

import org.junit.Assert.*
import org.junit.Test

class SongTest {

    @Test
    fun testSetDurationWithMinsAndSecsMoreThanNine() {
        val song = Song()
        song.setDuration(11, 42)
        assertEquals("11:42", song.duration)
    }

    @Test
    fun testSetDurationWithMinsLessThanTen() {
        val song = Song()
        song.setDuration(7, 17)
        assertEquals("07:17", song.duration)
    }

    @Test
    fun testSetDurationWithSecsLessThanTen() {
        val song = Song()
        song.setDuration(23, 2)
        assertEquals("23:02", song.duration)
    }

    @Test
    fun testSetDurationWithMinsAndSecsLessThanTen() {
        val song = Song()
        song.setDuration(5, 7)
        assertEquals("05:07", song.duration)
    }

    @Test
    fun testSetDurationWithMinsAndSecsZero() {
        val song = Song()
        song.setDuration(0, 0)
        assertEquals("00:00", song.duration)
    }
}