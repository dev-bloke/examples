package com.meridal.examples.springbootrabbitmq.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecordingTest {

    private static final String ID = "1234";
    private static final String OTHER_ID = "5678";

    @Test
    public void testEqualsAndHashCodeWithSameID() {
        final Recording recording = this.createRecording(ID);
        final Recording other = this.createRecording(ID);
        assertEquals(recording, other);
        assertEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentID() {
        final Recording recording = this.createRecording(ID);
        final Recording other = this.createRecording(OTHER_ID);
        assertNotEquals(recording, other);
        assertNotEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullID() {
        final Recording recording = this.createRecording(ID);
        final Recording other = this.createRecording(null);
        assertNotEquals(recording, other);
        assertNotEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithBothIDsNull() {
        final Recording recording = this.createRecording(null);
        final Recording other = this.createRecording(null);
        assertNotEquals(recording, other);
        assertEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsWithAnotherType() {
        final Recording recording = this.createRecording(ID);
        final List<Integer> other = new ArrayList<>();
        assertNotEquals(recording, other);
    }

    @Test
    public void testEqualsWithNull() {
        final Recording recording = this.createRecording(ID);
        assertNotEquals(recording, null);
    }

    @Test
    public void testAddSong() {
        final Recording recording = this.createRecording(ID);
        for (int i = 0; i < 10; i++) {
            recording.addSong(this.createSong(i));
        }
        final List<Song> songs = recording.getSongs();
        assertEquals(10, songs.size());
        for (int i = 0; i < 10; i++) {
            this.verifySong(songs.get(i), i);
        }
    }

    @Test
    public void testAddSongs() {
        final Recording recording = this.createRecording(ID);
        final List<Song> songs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            songs.add(this.createSong(i));
        }
        recording.setSongs(songs);
        final List<Song> recordingSongs = recording.getSongs();
        assertEquals(10, recordingSongs.size());
        for (int i = 0; i < 10; i++) {
            this.verifySong(recordingSongs.get(i), i);
        }
    }

    private Recording createRecording(final String id) {
        final Recording recording = new Recording();
        recording.setId(id);
        recording.setTitle("A Recording");
        recording.setArtist("Anne Artist");
        recording.setYear(1965);
        recording.setCatalogueNumber("CAT001");
        return recording;
    }

    private Song createSong(final int index) {
        final Song song = new Song();
        song.setTitle("A Song Title");
        song.setDuration(5, index);
        return song;
    }

    private void verifySong(final Song song, final int index) {
        assertNotNull(song);
        assertEquals("A Song Title", song.getTitle());
        assertEquals("05:0" + index, song.getDuration());
    }
}
