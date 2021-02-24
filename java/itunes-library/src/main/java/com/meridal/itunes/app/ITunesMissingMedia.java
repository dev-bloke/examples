package com.meridal.itunes.app;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meridal.itunes.domain.Directory;
import com.meridal.itunes.service.MediaService;
import com.meridal.itunes.service.RecordingsService;

public class ITunesMissingMedia implements Runnable {
	
	private static final Logger LOG = LoggerFactory.getLogger(ITunesMissingMedia.class);
	
	private RecordingsService recordingsService = new RecordingsService();
	private MediaService mediaService = new MediaService();
	
	public static void main(String[] args) {
		ITunesMissingMedia app = new ITunesMissingMedia();
		app.run();
	}	

	@Override
	public void run() {
		List<String> directories = this.recordingsService.getAllRecordingDirectories();
		try {
			for (String directory : directories) {
				Directory d = this.mediaService.getMediaDirectory(directory);
				if (d == null || !d.hasMedia()) {
					LOG.info(directory);
				}
			}
		}
		catch (IOException ioe) {
			LOG.error("Whoops. {}", ioe);
		}
		this.recordingsService.close();
		LOG.debug("Done.");
	}
}
