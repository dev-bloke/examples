package com.meridal.examples.springbootmysql.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.meridal.examples.springbootmysql.domain.Recording;
import com.meridal.examples.springbootmysql.domain.Song;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public abstract class TestFramework {

	private final Random random = new Random();

	protected Recording randomRecording() {
		return this.randomRecording(null);
	}

	protected Recording randomRecording(String id) {
		final Recording recording = new Recording();
		recording.setId(id);
		recording.setArtist(this.randomStringWithMaxLength(32));
		recording.setTitle(this.randomStringWithMaxLength(64));
		recording.setCatalogueNumber(this.randomStringWithMaxLength(16));
		recording.setYear(1965 + this.randomPositiveInteger(50));
		int tracks = this.randomPositiveInteger(20);
		final List<Song> songs = new ArrayList<>();
		for (int i = 0; i < tracks; i++) {
			songs.add(this.randomSong());
		}
		recording.setSongs(songs);
		return recording;
	}

	protected Recording cloneRecording(final String id, final Recording recording) {
		final Recording clone = new Recording();
		clone.setId(id);
		clone.setArtist(recording.getArtist());
		clone.setTitle(recording.getTitle());
		clone.setYear(recording.getYear());
		clone.setCatalogueNumber(recording.getCatalogueNumber());
		final List<Song> songs = new ArrayList<>(recording.getSongs());
		clone.setSongs(songs);
		return clone;
	}

	protected Song randomSong() {
		return this.randomSong(null);
	}

	protected Song randomSong(final Integer id) {
		final Song song = new Song();
		song.setId(id);
		song.setTitle(this.randomStringWithMaxLength(64));
		String mins = Integer.toString(this.randomPositiveInteger(20));
		String secs = Integer.toString(this.randomPositiveInteger(59));
		song.setDuration(mins + ":" + secs);
		return song;
	}

	protected Song cloneSong(final Integer id, final Song song) {
		final Song clone = new Song();
		clone.setId(id);
		clone.setDuration(song.getDuration());
		clone.setTitle(song.getTitle());
		return clone;
	}

	protected String saveRecording(final Recording recording, TestEntityManager entityManager) {
		final Recording saved = entityManager.persist(recording);
		entityManager.flush();
		return saved.getId();
	}

	private int randomPositiveInteger(int max) {
		return Math.floorMod(random.nextInt(), max - 1) + 1;
	}

	private String randomStringWithMaxLength(int max) {
		return RandomStringUtils.randomAlphanumeric(1, max);
	}
}
