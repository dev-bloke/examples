package com.meridal.examples.elasticsearch.test;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.meridal.examples.elasticsearch.domain.Recording;

public abstract class TestFramework {

    private static final String ARTIST = "Big Big Train";
    private static final String TITLE =  "Folklore";
    private static final String FORMAT = "lossless download";
    protected static final String WRONG_YEAR = "2015";
    protected static final String YEAR = "2016";

    private Random random = new Random();

    protected Recording createRecording(String id) {
        Recording recording = new Recording();
        recording.setId(id);
        recording.setArtist(ARTIST);
        recording.setTitle(TITLE);
        recording.setYear(WRONG_YEAR);
        recording.setFormat(FORMAT);
        return recording;
    }

    protected void checkRecording(Recording recording, String year) {
        assertNotNull(recording);
        assertEquals(ARTIST, recording.getArtist());
        assertEquals(TITLE, recording.getTitle());
        assertEquals(FORMAT, recording.getFormat());
        assertEquals(year, recording.getYear());
    }
        
    protected Recording randomRecording(String id) {
        Recording recording = new Recording();
        recording.setId(id);
        recording.setArtist(RandomStringUtils.randomAscii(16));
        recording.setTitle(RandomStringUtils.randomAscii(64));
        recording.setFormat(RandomStringUtils.randomAscii(8));
        int year = 1965 + (random.nextInt() % 50);
        recording.setYear(Integer.toString(year));
        return recording;
    }
}
