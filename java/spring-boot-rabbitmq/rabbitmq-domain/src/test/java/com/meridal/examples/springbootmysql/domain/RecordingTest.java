package com.meridal.examples.springbootmysql.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.meridal.examples.springbootmysql.test.RabbitMQTestFramework;

/**
 * Unit tests for {@link Recording}.
 */
public class RecordingTest extends RabbitMQTestFramework {
	
	@Test
	public void testGettersAndSetters() {
		final Recording recording = new Recording();
		recording.setId(ID);
		recording.setArtist(ARTIST);
		recording.setTitle(RECORDING);
		recording.setYear(YEAR);
		recording.addSong(this.createSong());
		recording.addSong(this.createOtherSong());
		assertEquals(ID, recording.getId());
		assertEquals(ARTIST, recording.getArtist());
		assertEquals(RECORDING, recording.getTitle());
		assertEquals(YEAR, recording.getYear());
		final List<Song> songs = recording.getSongs();
		assertEquals(2, songs.size());
		assertEquals(this.createSong(), songs.get(0));
		assertEquals(this.createOtherSong(), songs.get(1));
	}
	
	@Test
	public void testEqualsAndHashCodeWhenIdentical() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecording();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenIDsAreEqual() {
		final Recording recording = this.createRecording();
		final Recording other = this.createEmptyRecordingWithID();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenIDsAreDifferent() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecordingWithDifferentID();
		assertNotEquals(recording, other);
		assertNotEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenIDisNull() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecording();
		other.setId(null);
		assertNotEquals(recording, other);
		assertNotEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenObjectisNull() {
		final Recording recording = this.createRecording();
		assertNotEquals(recording, null);
	}
	
	@Test
	public void testEqualsAndHashCodeWhenTitlesAreDifferent() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecordingWithDifferentTitle();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenArtistsAreDifferent() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecordingWithDifferentArtist();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenYearsAreDifferent() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecordingWithDifferentYear();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenSongsAreDifferent() {
		final Recording recording = this.createRecording();
		final Recording other = this.createRecordingWithDifferentSongs();
		assertEquals(recording, other);
		assertEquals(recording.hashCode(), other.hashCode());
	}
}
