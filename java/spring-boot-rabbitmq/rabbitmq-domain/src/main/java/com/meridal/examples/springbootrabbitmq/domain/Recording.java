package com.meridal.examples.springbootrabbitmq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recording {
    
    private String id;
    
    private String artist;
    private String catalogueNumber;
    private List<Song> songs = new ArrayList<>();
    private String title;
    private Integer year;

    public void addSong(final Song song) {
        this.songs.add(song);
    }

    public void addSongs(final List<Song> songs) {
        if (songs != null) {
            for (final Song song: songs) {
                this.addSong(song);
            }
        }
    }
    
    public String getArtist() {
        return this.artist;
    }

    public String getCatalogueNumber() {
        return catalogueNumber;
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

    public void setCatalogueNumber(String catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public void setId(String id) {
        this.id = id;
    }    
    
    public void setSongs(List<Song> songs) {
        if (songs != null) {
            this.songs = songs;
        }
    }
    
    public void setTitle(String title) {       
	this.title = title;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        }
        else if (this.id != null && o instanceof Recording) {
            final Recording other = (Recording) o;
            result = Objects.equals(id, other.id);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
