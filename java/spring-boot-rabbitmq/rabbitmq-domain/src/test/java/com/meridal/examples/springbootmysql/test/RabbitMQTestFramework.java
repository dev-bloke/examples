package com.meridal.examples.springbootmysql.test;

import com.meridal.examples.springbootmysql.domain.Recording;
import com.meridal.examples.springbootmysql.domain.Song;

/**
 * Test framework with helper methods.
 */
public abstract class RabbitMQTestFramework {
	
	protected static final String ID = "CAT001";
	protected static final String ARTIST = "An Artist";
	protected static final String RECORDING = "A Recording";
	protected static final Integer YEAR = 2019;
	protected static final String OTHER_ID = "CAT002";
	protected static final String OTHER_ARTIST = "Another Artist";
	protected static final String OTHER_RECORDING = "Another Recording";
	protected static final Integer OTHER_YEAR = 2018;
	
	protected static final String TITLE = "A song";
	protected static final String DURATION = "3:00";
	protected static final String OTHER_TITLE = "Another song";
	protected static final String OTHER_DURATION = "4:00";
	
	protected Recording createEmptyRecording() {
		return new Recording();
	}
	
	protected Recording createEmptyRecordingWithID() {
		final Recording recording = new Recording();
		recording.setId(ID);
		return recording;
	}
	
	protected Recording createRecording() {
		final Recording recording = new Recording();
		recording.setId(ID);
		recording.setArtist(ARTIST);
		recording.setTitle(RECORDING);
		recording.setYear(YEAR);
		recording.addSong(this.createSong());
		recording.addSong(this.createOtherSong());
		return recording;
	}

	protected Recording createRecordingWithDifferentID() {
		final Recording recording = this.createRecording();
		recording.setId(OTHER_ID);
		return recording;
	}

	protected Recording createRecordingWithDifferentArtist() {
		final Recording recording = this.createRecording();
		recording.setArtist(OTHER_ARTIST);
		return recording;
	}

	protected Recording createRecordingWithDifferentTitle() {
		final Recording recording = this.createRecording();
		recording.setTitle(OTHER_RECORDING);
		return recording;
	}
	
	protected Recording createRecordingWithDifferentYear() {
		final Recording recording = this.createRecording();
		recording.setYear(OTHER_YEAR);
		return recording;
	}
	
	protected Recording createRecordingWithDifferentSongs() {
		final Recording recording = this.createRecording();
		recording.addSong(this.createSong());
		return recording;
	}
	
	protected Song createEmptySong() {
		return new Song();
	}

	protected Song createSong() {
		final Song song = new Song();
		song.setTitle(TITLE);
		song.setDuration(DURATION);
		return song;
	}

	protected Song createOtherSong() {
		final Song song = new Song();
		song.setTitle(OTHER_TITLE);
		song.setDuration(OTHER_DURATION);
		return song;
	}
	
	protected Song createSongWithDifferentTitle() {
		final Song song = new Song();
		song.setTitle(OTHER_TITLE);
		song.setDuration(DURATION);
		return song;
	}
	
	protected Song createSongWithDifferentDuration() {
		final Song song = new Song();
		song.setTitle(TITLE);
		song.setDuration(OTHER_DURATION);
		return song;
	}
}
