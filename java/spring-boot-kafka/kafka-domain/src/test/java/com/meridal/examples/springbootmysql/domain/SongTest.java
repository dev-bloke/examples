package com.meridal.examples.springbootmysql.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.meridal.examples.springbootmysql.test.KafkaTestFramework;

/**
 * Unit tests for {@link Song} domain object.
 */
public class SongTest extends KafkaTestFramework {
			
	@Test
	public void testSettersAndGetters() {
		final Song song = this.createSong();
		song.setTitle(TITLE);
		song.setDuration(DURATION);
		assertEquals(TITLE, song.getTitle());
		assertEquals(DURATION, song.getDuration());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenIdentical() {
		final Song song = this.createSong();
		final Song other = createSong();
		assertTrue(song.equals(other));
		assertEquals(song.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenTitleIsDifferent() {
		final Song song = this.createSong();
		final Song other = createSongWithDifferentTitle();
		assertNotEquals(song, other);
		assertNotEquals(song.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWhenDurationIsDifferent() {
		final Song song = this.createSong();
		final Song other = createSongWithDifferentDuration();
		assertNotEquals(song, other);
		assertNotEquals(song.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWithNullValues() {
		final Song song = this.createSong();
		final Song other = createEmptySong();
		assertNotEquals(song, other);
		assertNotEquals(song.hashCode(), other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWithNull() {
		assertNotEquals(this.createSong(), null);
	}
}