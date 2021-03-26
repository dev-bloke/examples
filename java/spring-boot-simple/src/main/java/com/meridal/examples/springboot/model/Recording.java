package com.meridal.examples.springboot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recording {

    public Recording() {
    }

    public Recording(final String artist, final String title, final String catalogueNumber) {
        this.setArtist(artist);
        this.setTitle(title);
        this.setCatalogueNumber(catalogueNumber);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String artist;
    private String title;
    private String catalogueNumber;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setCatalogueNumber(final String catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        }
        else if (this.id != null && o != null && o instanceof Recording){
            final Recording other = (Recording) o;
            result = this.id.equals(other.id);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id.intValue();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
