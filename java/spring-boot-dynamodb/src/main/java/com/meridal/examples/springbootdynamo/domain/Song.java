package com.meridal.examples.springbootdynamo.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Song {
    
    private String title;
    private String duration;
    
    @DynamoDBAttribute
    public String getTitle() {
        return this.title;
    }

    @DynamoDBAttribute
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
