package com.meridal.examples.elasticsearch.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "sandbox", type = "recording")
public class Recording implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String title;
    private String artist;
    private String year;
    private String format;

    public String getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getArtist() {
        return this.artist;
    }
    
    public String getYear() {
        return this.year;
    }
    
    public String getFormat() {
        return this.format;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public void setFormat(String format) {
        this.format = format;
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
