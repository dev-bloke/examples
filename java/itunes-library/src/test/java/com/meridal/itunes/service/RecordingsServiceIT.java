package com.meridal.itunes.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.test.TestFramework;

public class RecordingsServiceIT extends TestFramework {

	private static final Logger LOG = LoggerFactory.getLogger(RecordingsServiceIT.class);
	
	private RecordingsService service = new RecordingsService();
	
	@Test
	public void testRecordingCRUD() {
		Recording recording = this.createRecording();
		Song song = this.createSong();
		recording.addSong(song);
		this.service.saveRecording(recording);
		Integer recordingId = recording.getId();
		Integer songId = song.getId();
		LOG.debug("Recording saved, ID={}", recordingId);
		LOG.debug("Song saved, ID={}", songId);
		Recording found = this.service.findRecording(recordingId);
		this.checkRecording(found, YEAR);
		Collection<Song> songs = found.getSongs();
		assertNotNull(songs);
		assertEquals(1, songs.size());
		for (Song foundSong : songs) {
			this.checkSong(foundSong, YEAR);
		}
		this.service.deleteRecording(recording);
		found = this.service.findRecording(recordingId);
		assertNull(found);
	}
}

