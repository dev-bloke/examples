package com.meridal.itunes.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.RecordingKey;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.service.ITunesService;
import com.meridal.itunes.service.RecordingsService;

public class ITunesCreateDatabase implements Runnable {
	
	private static final Logger LOG = LoggerFactory.getLogger(ITunesCreateDatabase.class);

	private static final int MAX_STRING_SIZE = 255;
	
	public static void main(String[] args) {
		ITunesCreateDatabase app = new ITunesCreateDatabase(args);
		app.run();
	}
	
	private String fileName;
	
	public ITunesCreateDatabase(String fileName) {
		this.fileName = fileName;
	}
	
	public ITunesCreateDatabase(String[] args) {
		this.getFileNameFromCommandLineArgs(args);
	}

	@Override
	public void run() {
		if (this.fileName != null) {
			ITunesService iTunes = new ITunesService();
			RecordingsService recordings = new RecordingsService();
			Map<RecordingKey, Recording> albums = iTunes.getAlbums(this.fileName);
			LOG.info("{} albums retrieved from iTunes.", albums.size());
			int truncated = 0;
			int processed = 0;
			List<Recording> incomplete = new ArrayList<>();
			for (Recording album : albums.values()) {
				if (album.getArtist() == null) {
					incomplete.add(album);
				}
				else {
					LOG.debug("{} - {} ({})", album.getArtist(), album.getTitle(), album.getYear());
					truncated += this.refresh(album);			    
					recordings.saveRecording(album);
					processed++;
				}
			}
			LOG.info("{} albums written to database.", processed);
			if (truncated > 0) {
				LOG.warn("{} song file names truncated.", truncated);
			}
			this.reportIncomplete(incomplete);
			LOG.debug("Closing service.");
			recordings.close();
			LOG.debug("Done.");
		}
	}
	
	private void getFileNameFromCommandLineArgs(String[] args) {
		if (args == null || args.length == 0) {
			String appClass = this.getClass().getName();
			LOG.error("Usage: {} <path-to-itunes-library-file>", appClass);
		}
		else {
			this.fileName = args[0];
		}
	}
	
	public int refresh(Recording recording) {
		int truncated = 0;
		if (recording != null) {
			int totalTime = 0;
			int totalSize = 0;			
			Collection<Song> songs = recording.getSongs();
			if (songs != null) {
			    for (Song song : songs) {
			    	Integer time = song.getTimeMs();
			    	Integer size = song.getFileSize();
			    	if (time == null) {
			    		LOG.warn("Time for current album may be incomplete.");
			    	}
			    	else {
			    	    totalTime += time;
			    	}
			    	if (size == null) {
			    		LOG.warn("Directory size for current album may be incomplete.");
			    	}
			    	else {
			    	    totalSize += size;
			    	}
			    	if (song.getFileName().length() > MAX_STRING_SIZE) {
			    		song.setFileName(song.getFileName().substring(0, MAX_STRING_SIZE));
			    		truncated++;
			    	}
			    }
			}
			recording.setTimeMs(totalTime);
			recording.setDirectorySize(totalSize);
		}
		return truncated;
	}
	
	public void reportIncomplete(List<Recording> recordings) {
		if (recordings != null && recordings.size() > 0) {
			LOG.warn("The following tracks were skipped as the metadata appears incomplete.");
			for (Recording recording : recordings) {
				for (Song song : recording.getSongs()) {
					LOG.warn(song.getFileName());
				}
			}
		}
	}
}
