package com.meridal.itunes.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Unique identifier (composite key) for {@link Recording}.
 * @author Martin Ingram
 */
public class RecordingKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String artist;
	private final String title;
	
	public RecordingKey(String artist, String title, Integer year) {
		this.artist = artist;
		this.title = title;
	}
	
	public String getArtist() {
		return this.artist;
	}
		
	public String getTitle() {
		return this.title;
	}
		
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}	
}
