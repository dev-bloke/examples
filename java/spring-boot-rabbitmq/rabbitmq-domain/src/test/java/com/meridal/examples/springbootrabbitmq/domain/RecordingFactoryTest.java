package com.meridal.examples.springbootrabbitmq.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecordingFactoryTest {

    private static final String ARTIST = "Anne Artist";
    private static final String ID = "RECORDING-1";
    private static final String TITLE = "A Recording Title";
    private static final String CAT_NO = "CAT001";
    private static final Integer YEAR = 1965;
    private static final String SONG_TITLE = "A Song Title";
    private static final int MINS = 5;
    private static final int SECS = 17;
    private static final String DURATION = "05:17";
    private static final String OTHER_ID = "RECORDING-2";

    @Test
    public void testCreateSong() {
        final Song song = RecordingFactory.createSong(SONG_TITLE, MINS, SECS);
        this.validateSong(song);
    }

    @Test
    public void testRandomSong() {
        final Song song = RecordingFactory.randomSong();
        this.validateRandomSong(song);
    }

    @Test
    public void testCreateRecording() {
        final Recording recording = RecordingFactory.createRecording(ID, ARTIST, TITLE, CAT_NO, YEAR);
        this.validateRecording(recording, ID, 0);
    }

    @Test
    public void testCreateRecordingWithSongs() {
        final Song song = RecordingFactory.createSong(SONG_TITLE, MINS, SECS);
        final List<Song> songs = new ArrayList<>();
        songs.add(song);
        final Recording recording = RecordingFactory.createRecording(ID, ARTIST, TITLE, CAT_NO, YEAR, songs);
        this.validateRecording(recording, ID, 1);
        this.validateSong(recording.getSongs().get(0));
    }

    @Test
    public void testCloneRecording() {
        final Song song = RecordingFactory.createSong(SONG_TITLE, MINS, SECS);
        final List<Song> songs = new ArrayList<>();
        songs.add(song);
        final Recording recording = RecordingFactory.createRecording(ID, ARTIST, TITLE, CAT_NO, YEAR, songs);
        final Recording other = RecordingFactory.cloneRecording(OTHER_ID, recording);
        this.validateRecording(other, OTHER_ID, 1);
        this.validateSong(other.getSongs().get(0));
    }

    @Test
    public void testRandomRecordingWithID() {
        final Recording recording = RecordingFactory.randomRecording(ID);
        this.validateRandomRecording(recording, ID);
    }

    @Test
    public void testRandomRecordingWithNoID() {
        final Recording recording = RecordingFactory.randomRecording();
        this.validateRandomRecording(recording, null);
    }

    private void validateSong(final Song song) {
        assertNotNull(song);
        assertEquals(SONG_TITLE, song.getTitle());
        assertEquals(DURATION, song.getDuration());
    }

    private void validateRecording(final Recording recording, final String id, final int numSongs) {
        assertNotNull(recording);
        assertNotNull(recording.getSongs());
        assertEquals(numSongs, recording.getSongs().size());
        assertEquals(id, recording.getId());
        assertEquals(ARTIST, recording.getArtist());
        assertEquals(TITLE, recording.getTitle());
        assertEquals(CAT_NO, recording.getCatalogueNumber());
        assertEquals(YEAR, recording.getYear());
    }

    private void validateRandomSong(final Song song) {
        assertNotNull(song);
        assertNotNull(song.getTitle());
        assertNotNull(song.getDuration());
    }

    private void validateRandomRecording(final Recording recording, final String id) {
        assertNotNull(recording);
        assertNotNull(recording.getSongs());
        assertTrue(recording.getSongs().size() > 0);
        assertEquals(id, recording.getId());
        assertNotNull(recording.getArtist());
        assertNotNull(recording.getTitle());
        assertNotNull(recording.getCatalogueNumber());
        assertNotNull(recording.getYear());
    }
}
