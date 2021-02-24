package com.meridal.examples.domain;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@DynamoDBTable(tableName = "recordings")
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
    
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey 
    public String getId() {
        return this.id;
    }

    @DynamoDBAttribute
    public List<Song> getSongs() {
        return this.songs;
    }
    
    @DynamoDBAttribute
    public String getTitle() {
        return this.title;
    }
    
    @DynamoDBAttribute
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