package com.meridal.itunes.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.meridal.itunes.domain.Directory;

public class MediaService {
	
	/**
	 * Get directory statistics for the given path.
	 * @param path Path
	 * @return Directory statistics
	 */
	public Directory getMediaDirectory(String path) throws IOException {
		File d = new File(path);
		return this.getMediaDirectory(d);
	}
	
	/**
	 * Get directory statistics for the given File pointer.
	 * @param d File pointer
	 * @return Directory statistics
	 */
	public Directory getMediaDirectory(File d) throws IOException {
		Directory directory = null;
		if (d.isDirectory()) {
			int fileCount = 0;
			String path = d.getCanonicalPath();
			for (File f : d.listFiles()) {
				if (f.isFile() && !f.getName().startsWith(".")) {
					fileCount++;
				}
			}
			directory = new Directory(path, fileCount);
		}
		return directory;
	}
	
	/**
	 * Recurse through the directory structure at the supplied path and return the path
	 * for all directories containing media.
	 * @param path Path
	 * @return List of directory statistics
	 */

	public List<String> getMediaDirectoryPaths(String path) throws IOException {
		List<String> names = new ArrayList<>();
		for (Directory directory : this.getMediaDirectories(path)) {
			names.add(directory.getPath());
		}
		return names;
	}
	
	/**
	 * Recurse through the directory structure at the supplied path and return statistics
	 * for all directories containing media.
	 * @param path Path
	 * @return List of directory statistics
	 */
	public List<Directory> getMediaDirectories(String path) throws IOException {
		File d = new File(path);
		return this.getMediaDirectories(d);
	}
	
	/**
	 * Recurse through the directory structure at the supplied File pointer and return statistics
	 * for all directories containing media.
	 * @param d File pointer
	 * @return List of directory statistics
	 */
	public List<Directory> getMediaDirectories(File d) throws IOException {
		List<Directory> directories = new ArrayList<>();
		if (d.isDirectory()) {
			Directory directory = this.getMediaDirectory(d);
			if (directory.hasMedia()) {
				directories.add(directory);
			}
			for (File f : d.listFiles()) {
				if (f.isDirectory()) {
					directories.addAll(this.getMediaDirectories(f));
				}
			}
		}
		return directories;
	}
}
