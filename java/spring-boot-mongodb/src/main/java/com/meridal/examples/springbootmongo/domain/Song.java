package com.meridal.examples.springbootmongo.domain;

public class Song {
    
    private String title;
    private String duration;
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
