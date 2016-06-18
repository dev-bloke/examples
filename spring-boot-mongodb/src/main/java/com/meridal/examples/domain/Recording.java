package com.meridal.examples.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="recordings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording {
    
    private String id;
    
    private String artist;
    private List<Song> songs;
    private String title;
    private Integer year;
    
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
}
