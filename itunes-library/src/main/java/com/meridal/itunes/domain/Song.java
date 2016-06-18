package com.meridal.itunes.domain;

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
@Table(name="song")
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="recording_id")
	private Integer recordingId;
	
	@Column(name="artist")
    private String artist;
	
	@Column(name="bit_rate")
    private Integer bitRate;
	
	@Column(name="comments")
    private String comments;
	
	@Column(name="disc_no")
    private Integer discNo;
	
	@Column(name="file_name")
    private String fileName;
	
	@Column(name="file_size")
    private Integer fileSize;
	
	@Column(name="file_type")
    private String fileType;
	
	@Transient
	private boolean local;
	
	@Column(name="name")
    private String name;
	
	@Column(name="sample_rate")
    private Integer sampleRate;
	
	@Column(name="track_no")
    private Integer trackNo;
	
	@Column(name="time")
    private String time;
	
	@Column(name="time_ms")
    private Integer timeMs;
	
	@Column(name="year")
    private Integer year;
	
	public Song() {
		this.local = true;
	}
    
    public String getArtist() {
        return this.artist;
    }

    public Integer getBitRate() {
        return this.bitRate;
    }

    public String getComments() {
		return comments;
	}

	public Integer getDiscNo() {
        return this.discNo;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Integer getFileSize() {
        return this.fileSize;
    }

    public String getFileType() {
        return this.fileType;
    }
    
    public Integer getId() {
		return id;
	}

	public String getName() {
        return this.name;
    }

	public Integer getRecordingId() {
		return recordingId;
	}

    public Integer getSampleRate() {
        return this.sampleRate;
    }

    public Integer getTrackNo() {
        return this.trackNo;
    }   
    
    public String getTime() {
        return this.time;
    }
           
    public Integer getTimeMs() {
		return timeMs;
	}

	public Integer getYear() {
		return year;
	}
	
	public boolean isLocal() {
		return this.local;
	}

	public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

	public void setComments(String comments) {
		this.comments = comments;
	}
    
    public void setDiscNo(Integer discNo) {
        this.discNo = discNo;
    }

    public void setId(Integer id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public void setLocal(boolean local) {
    	this.local = local;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setRecordingId(Integer recordingId) {
		this.recordingId = recordingId;
	}

    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }
       
	public void setTimeMs(Integer timeMs) {
		this.timeMs = timeMs;
		this.time = TimeHelper.getMinsTimeFromMillis(timeMs);
	}
    
	public void setYear(Integer year) {
		this.year = year;
	}
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
