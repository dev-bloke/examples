package com.meridal.examples.springbootrabbitmq.domain;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecordingFactory {

    private static final Random random = new Random();

    public static Recording createRecording(final String id, final String artist, final String title,
        final String catalogueNumber, final Integer year) {
        final Recording recording = new Recording();
        recording.setId(id);
        recording.setArtist(artist);
        recording.setTitle(title);
        recording.setCatalogueNumber(catalogueNumber);
        recording.setYear(year);
        return recording;
    }

    public static Recording createRecording(final String id, final String artist, final String title,
        final String catalogueNumber, final Integer year, final List<Song> songs) {
        final Recording recording = createRecording(id, artist, title, catalogueNumber, year);
        recording.addSongs(songs);
        return recording;
    }

    public static Recording cloneRecording(final String id, final Recording recording) {
        final Recording clone = new Recording();
        clone.setId(id);
        clone.setArtist(recording.getArtist());
        clone.setTitle(recording.getTitle());
        clone.setYear(recording.getYear());
        clone.setCatalogueNumber(recording.getCatalogueNumber());
        clone.addSongs(recording.getSongs());
        return clone;
    }
    protected static Recording randomRecording() {
        return randomRecording(null);
    }

    protected static Recording randomRecording(String id) {
        final Recording recording = new Recording();
        recording.setId(id);
        recording.setArtist(randomStringWithMaxLength(32));
        recording.setTitle(randomStringWithMaxLength(64));
        recording.setCatalogueNumber(randomStringWithMaxLength(16));
        recording.setYear(1965 + randomPositiveInteger(50));
        int tracks = randomPositiveInteger(20);
        for (int i = 0; i < tracks; i++) {
            recording.addSong(randomSong());
        }
        return recording;
    }

    public static Song createSong(final String title, final int minutes, final int seconds) {
        final Song song = new Song();
        song.setTitle(title);
        song.setDuration(minutes, seconds);
        return song;
    }

    public static Song cloneSong(final Song song) {
        final Song clone = new Song();
        clone.setDuration(song.getDuration());
        clone.setTitle(song.getTitle());
        return clone;
    }

    protected static Song randomSong() {
        return createSong(randomStringWithMaxLength(64), randomPositiveInteger(20), randomPositiveInteger(59));
    }

    private static int randomPositiveInteger(final int max) {
        return Math.floorMod(random.nextInt(), max - 1) + 1;
    }

    private static String randomStringWithMaxLength(final int max) {
        return RandomStringUtils.randomAlphanumeric(1, max);
    }
}
