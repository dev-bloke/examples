package com.meridal.itunes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.Song;

public abstract class TestFramework {
	
	private static final String ARTIST = "Yes";
	private static final String ALBUM_TITLE = "Fragile";
	private static final Integer BIT_RATE = 1024;
	private static final String DIRECTORY = "/Music/Yes/Fragile";
	private static final Integer DIRECTORY_SIZE = 987654;
	private static final String COMMENTS = "A song from Fragile.";
	private static final Boolean COMPILATION = false;
	private static final Integer DISC_COUNT = 1;
	private static final Integer DISC_NO = 1;
	private static final String FILE_NAME = DIRECTORY + "/Heart Of The Sunrise.m4a";
	private static final Integer FILE_SIZE = 0;
	private static final String FILE_TYPE = "Apple Lossless Audio";
	private static final String NAME = "Heart Of The Sunrise";
	private static final Integer RECORDING_ID = 1;
	private static final Integer SAMPLE_RATE = 44100;
	private static final Integer TRACK_NO = 9;
	private static final String TIME = "11:27";
	private static final Integer TIME_MS = 687000;
	protected static final Integer US_RELEASE = 1972;
	protected static final Integer YEAR = 1971;

	protected Recording createRecording() {
		Recording recording = new Recording();
		recording.setArtist(ARTIST);
		recording.setCompilation(COMPILATION);
		recording.setDirectory(DIRECTORY);
		recording.setDirectorySize(DIRECTORY_SIZE);
		recording.setDiscCount(DISC_COUNT);
		recording.setFileType(FILE_TYPE);
		recording.setTitle(ALBUM_TITLE);
		recording.setYear(YEAR);
		return recording;
	}
	
	protected void checkRecording(Recording recording, Integer year) {
		assertNotNull(recording);
		assertEquals(ALBUM_TITLE, recording.getTitle());
		assertEquals(ARTIST, recording.getArtist());
		assertEquals(COMPILATION, recording.getCompilation());
		assertEquals(DIRECTORY, recording.getDirectory());
		assertEquals(DIRECTORY_SIZE, recording.getDirectorySize());
		assertEquals(DISC_COUNT, recording.getDiscCount());
		assertEquals(FILE_TYPE, recording.getFileType());
		assertEquals(year, recording.getYear());
	}
	
	protected Song createSong() {
		Song song = new Song();
		song.setArtist(ARTIST);
		song.setBitRate(BIT_RATE);
		song.setComments(COMMENTS);
		song.setDiscNo(DISC_NO);
		song.setFileName(FILE_NAME);
		song.setFileSize(FILE_SIZE);
		song.setFileType(FILE_TYPE);
		song.setName(NAME);
		song.setRecordingId(RECORDING_ID);
		song.setSampleRate(SAMPLE_RATE);
		song.setTimeMs(TIME_MS);
		song.setTrackNo(TRACK_NO);
		song.setYear(YEAR);
		return song;
	}
	
	protected void checkSong(Song song, Integer year) {
		assertNotNull(song);
		assertEquals(ARTIST, song.getArtist());
		assertEquals(BIT_RATE, song.getBitRate());
		assertEquals(COMMENTS, song.getComments());
		assertEquals(DISC_NO, song.getDiscNo());
		assertEquals(FILE_NAME, song.getFileName());
		assertEquals(FILE_SIZE, song.getFileSize());
		assertEquals(FILE_TYPE, song.getFileType());
		assertEquals(NAME, song.getName());
		assertEquals(RECORDING_ID, song.getRecordingId());
		assertEquals(SAMPLE_RATE, song.getSampleRate());
		assertEquals(TIME_MS, song.getTimeMs());
		assertEquals(TIME, song.getTime());
		assertEquals(TRACK_NO, song.getTrackNo());
		assertEquals(year, song.getYear());
	}
}
