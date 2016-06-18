package com.meridal.examples.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="recordings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    
    @Column(name="artist")
    private String artist;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="recording_id")
    private List<Song> songs;
    
    @Column(name="title")
    private String title;
    
    @Column(name="year")
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
