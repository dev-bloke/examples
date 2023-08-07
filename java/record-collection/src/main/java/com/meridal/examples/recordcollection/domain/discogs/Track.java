package com.meridal.examples.recordcollection.domain.discogs;

public class Track {

	private String duration;
	private String position;
	private String title;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.position + " " + this.title + " " + this.duration;
	}
}
