package com.meridal.itunes.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.test.TestFramework;

public class RecordingsRepositoryIT extends TestFramework {

	private static final Logger LOG = LoggerFactory.getLogger(RecordingsRepositoryIT.class);
		
	private RecordingsRepository repository = new RecordingsRepository();
	
	@Test
	public void testRecordingCRUD() {
		Recording recording = this.createRecording();
		this.repository.saveRecording(recording);
		Integer id = recording.getId();
		LOG.debug("Recording saved, ID={}", id);
		Recording found = this.repository.findRecording(id);
		this.checkRecording(found, YEAR);
		recording.setYear(US_RELEASE);
		this.repository.saveRecording(recording);
		found = this.repository.findRecording(id);
		this.checkRecording(found, US_RELEASE);
		this.repository.deleteRecording(recording);
		found = this.repository.findRecording(id);
		assertNull(found);
	}
	
	@Test
	public void testSongCRUD() {
		Song song = this.createSong();
		this.repository.saveSong(song);
		Integer id = song.getId();
		LOG.debug("Song saved, ID={}", id);
		Song found = this.repository.findSong(id);
		this.checkSong(found, YEAR);
		song.setYear(US_RELEASE);
		this.repository.saveSong(song);
		found = this.repository.findSong(id);
		this.checkSong(found, US_RELEASE);
		this.repository.deleteSong(song);
		found = this.repository.findSong(id);
		assertNull(found);
	}
	
	@Test
	public void testFindSongByRecording() {
		Song song = this.createSong();
		this.repository.saveSong(song);
		Integer id = song.getRecordingId();
		List<Song> songs = this.repository.findSongsForRecording(id);
		assertNotNull(songs);
		assertEquals(1, songs.size());
		Song found = songs.get(0);
		this.checkSong(found, YEAR);
		this.repository.deleteSong(song);
		songs = this.repository.findSongsForRecording(id);
		assertNotNull(songs);
		assertEquals(0, songs.size());
	}
}
