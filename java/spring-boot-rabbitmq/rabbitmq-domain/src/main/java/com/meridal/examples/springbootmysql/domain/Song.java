package com.meridal.examples.springbootmysql.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Song domain object.
 */
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
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public void setDuration(final String duration) {
        this.duration = duration;
    }
    
    @Override
    public boolean equals(Object obj) {
    	boolean equals = false;
    	if (obj != null && obj instanceof Song) {
    		final Song other = (Song) obj;
    		equals = EqualsBuilder.reflectionEquals(this, other);
    	}
    	return equals;
    }
    
    @Override
    public int hashCode() {
    	return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}