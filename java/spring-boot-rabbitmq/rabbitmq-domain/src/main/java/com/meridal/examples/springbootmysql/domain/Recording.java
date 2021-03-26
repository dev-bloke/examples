package com.meridal.examples.springbootmysql.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Recording domain object.
 */
public class Recording implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private String id;
    
    private String artist;
    private List<Song> songs;
    private String title;
    private Integer year;
    
    public Recording() {
    	this.songs = new ArrayList<>();
    }
    
    public void addSong(final Song song) {
    	this.songs.add(song);
    }
    
    public String getArtist() {
        return this.artist;
    }
    
    public String getId() {
        return this.id;
    }

    public List<Song> getSongs() {
        return this.songs;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public Integer getYear() {
        return this.year;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public void setId(String id) {
        this.id = id;
    }    
    
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    
    public void setTitle(String title) {       
	this.title = title;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    @Override
    public boolean equals(Object obj) {
    	boolean equals = false;
    	if (obj != null && obj instanceof Recording) {
    		final Recording other = (Recording) obj;
    		equals = StringUtils.equals(this.id, other.id);
    	}
    	return equals;
    }
    
    @Override
    public int hashCode() {
    	return this.id != null ? this.id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
