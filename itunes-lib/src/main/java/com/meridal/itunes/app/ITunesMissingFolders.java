package com.meridal.itunes.app;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meridal.itunes.service.MediaService;
import com.meridal.itunes.service.RecordingsService;

public class ITunesMissingFolders implements Runnable {
	
	private static final Logger LOG = LoggerFactory.getLogger(ITunesMissingFolders.class);
	
	public static void main(String[] args) {
		ITunesMissingFolders app = new ITunesMissingFolders(args);
		app.run();
	}
	
	private MediaService mediaService = new MediaService();
	private RecordingsService recordingsService = new RecordingsService();
	
	private String path;
	
	public ITunesMissingFolders(String path) {
		this.path = path;
	}
	
	public ITunesMissingFolders(String[] args) {
		this.getDirectoryNameFromCommandLineArgs(args);
	}

	@Override
	public void run() {
		if (this.path != null) {
			try {
				List<String> recordings = this.recordingsService.getAllRecordingDirectories();
				List<String> directories = this.mediaService.getMediaDirectoryPaths(this.path);
				for (String directory : directories) {
					if (!recordings.contains(directory)) {
						LOG.info(directory);
					}
				}
			}
			catch (IOException ioe) {
				LOG.error("Ooops!, {}", ioe);
			}
		}
		this.recordingsService.close();
	}
	
	private void getDirectoryNameFromCommandLineArgs(String[] args) {
		if (args == null || args.length == 0) {
			String appClass = this.getClass().getName();
			LOG.error("Usage: {} <path>", appClass);
		}
		else {
			this.path = args[0];
		}
	}
	
	private String checkFor(List<String> recordings, String recording) {
		String found = "";
		for (String title : recordings) {
			if (title.contains(recording)) {
				LOG.debug("Found '{}'", title);
				found = title;
			}
		}
		return found;
	}
}
