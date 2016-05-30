package com.meridal.itunes.service;

import java.util.ArrayList;
import java.util.List;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.repository.RecordingsRepository;

public class RecordingsService {
	
	private RecordingsRepository repository;
	
	public RecordingsService() {
		this.repository = new RecordingsRepository();
	}
	
	public void saveRecording(Recording recording) {
		if (recording != null) {
			this.repository.saveRecording(recording);
			Integer id = recording.getId();
			for (Song song : recording.getSongs()) {
				song.setRecordingId(id);
				this.repository.saveSong(song);
			}
		}
	}
	
	public List<Recording> findAllRecordings() {
		return this.repository.findAllRecordings();
	}
	
	public Recording findRecording(Integer id) {
		Recording recording = this.repository.findRecording(id);
		if (recording != null) {
			List<Song> songs = this.repository.findSongsForRecording(id);
			recording.setSongs(songs);
		}
		return recording;
	}
	
	public void deleteRecording(Recording recording) {
		if (recording != null) {
			for (Song song : recording.getSongs()) {
				this.repository.deleteSong(song);
			}
			this.repository.deleteRecording(recording);
		}
	}
	
	public List<String> getAllRecordingDirectories() {
		List<String> directories = new ArrayList<>();
		List<Recording> recordings = this.findAllRecordings();
		for (Recording recording : recordings) {
			directories.add(recording.getDirectory());
		}
		return directories;
	}
	
	public void close() {
		this.repository.close();
	}
}
