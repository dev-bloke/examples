package com.meridal.examples.springbootrabbitmq.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SongTest {

    @Test
    public void testSetDurationWithMinsAndSecsMoreThanNine() {
        final Song song = new Song();
        song.setDuration(11, 42);
        assertEquals(song.getDuration(), "11:42");
    }

    @Test
    public void testSetDurationWithMinsLessThanTen() {
        final Song song = new Song();
        song.setDuration(7, 17);
        assertEquals(song.getDuration(), "07:17");
    }

    @Test
    public void testSetDurationWithSecsLessThanTen() {
        final Song song = new Song();
        song.setDuration(23, 2);
        assertEquals(song.getDuration(), "23:02");
    }

    @Test
    public void testSetDurationWithMinsAndSecsLessThanTen() {
        final Song song = new Song();
        song.setDuration(5, 7);
        assertEquals(song.getDuration(), "05:07");
    }

    @Test
    public void testSetDurationWithMinsAndSecsZero() {
        final Song song = new Song();
        song.setDuration(0, 0);
        assertEquals(song.getDuration(), "00:00");
    }
}
