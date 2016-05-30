package com.meridal.itunes.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.meridal.itunes.helper.TimeHelper;

@Entity
@Table(name="recording")
public class Recording {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="artist")
	private String artist;
    
    @Column(name="compilation")
    private Boolean compilation;
    
    @Column(name="directory")
    private String directory;
    
    @Column(name="directory_size")
    private Integer directorySize;
    
    @Column(name="disc_count")
    private Integer discCount;
    
    @Column(name="file_type")
    private String fileType;
    
    @Transient
    private Collection<Song> songs;
    
    @Column(name="time")
    private String time;
    
    @Column(name="time_ms")
    private Integer timeMs;
    
    @Column(name="title")
    private String title;
    
    @Column(name="year")
    private Integer year;
    
    public Recording() {
    	this.songs = new ArrayList<>();
    }
    
    public Recording(RecordingKey key, Song song, Boolean compilation) {
    	this.id = null;
    	this.artist = key.getArtist();
    	this.title = key.getTitle();
    	this.year = song.getYear();
    	this.compilation = compilation;
    	this.songs = new ArrayList<>();
    	this.songs.add(song);
    	this.directory = this.getDirectory(song.getFileName());
    	this.directorySize = song.getFileSize();
    	this.discCount = song.getDiscNo();
    	this.fileType = song.getFileType();
    }
    
    public void addSong(Song song) {
    	if (song != null) {
    		this.songs.add(song);
    		if (this.directorySize == null) {
    			this.directorySize = song.getFileSize();
    		}
    		else if (song.getFileSize() != null) {
    			this.directorySize += song.getFileSize();
    		}   		
    		if ((this.discCount == null) || (song.getDiscNo() != null && song.getDiscNo() > this.discCount)) {
    			this.discCount = song.getDiscNo();
    		}
    		if (this.year == null || (song.getYear() != null && song.getYear() > this.year)) {
    			this.year = song.getYear();
    		}
    	}
    }

    public String getArtist() {
        return this.artist;
    }

    public Boolean getCompilation() {
        return this.compilation;
    }

    public String getDirectory() {
        return this.directory;
    }

    public Integer getDirectorySize() {
        return this.directorySize;
    }

    public Integer getDiscCount() {
        return this.discCount;
    }

    public String getFileType() {
        return this.fileType;
    }
    
    public Integer getId() {
    	return this.id;
    }

    public Collection<Song> getSongs() {
        return this.songs;
    }
    

	public String getTime() {
		return time;
	}
    
	public Integer getTimeMs() {
		return timeMs;
	}

    public String getTitle() {
        return this.title;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setId(Integer id) {
		this.id = id;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setCompilation(Boolean compilation) {
		this.compilation = compilation;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public void setDirectorySize(Integer directorySize) {
		this.directorySize = directorySize;
	}

	public void setDiscCount(Integer discCount) {
		this.discCount = discCount;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setSongs(Collection<Song> songs) {
		this.songs = songs;
	}
	
	public void setTimeMs(Integer timeMs) {
		this.timeMs = timeMs;
		this.time = TimeHelper.getTimeFromMillis(timeMs);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    private String getDirectory(String fileName) {
    	String directory = fileName;
    	if (fileName != null) {
    		int lastSlash = fileName.lastIndexOf('/');
    		if (lastSlash > 0) {
    			directory = fileName.substring(0, lastSlash);
    		}
    	}
    	return directory;
    }
}

