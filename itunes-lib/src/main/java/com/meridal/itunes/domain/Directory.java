package com.meridal.itunes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Directory {

	private final Integer fileCount;
	private final String path;
	
	public Directory(String path, Integer fileCount) {
		this.path = path;
		this.fileCount = fileCount;
	}

	public Integer getFileCount() {
		return fileCount;
	}

	public String getPath() {
		return path;
	}
	
	public boolean hasMedia() {
		return this.fileCount > 0;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
