package com.meridal.examples.springbootrabbitmq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Locale;

public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public void setDuration(int mins, int secs) {
        this.duration = this.formatTimePart(mins) + ":" + this.formatTimePart(secs);
    }

    private String formatTimePart(int timePart) {
        return String.format(Locale.UK, "%02d", timePart);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
