package com.meridal.itunes.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.PropertyListParser;
import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.RecordingKey;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.helper.PathHelper;

public class ITunesService {

	private static final String ALBUM = "Album";
	private static final String ARTIST = "Artist";
	private static final String BIT_RATE = "Bit Rate";
	private static final String COMMENTS = "Comments";
	private static final String COMPILATION = "Compilation";
	private static final String DISC_NO = "Disc Number";
	private static final String FILE_NAME = "Location";
	private static final String FILE_SIZE = "Size";
	private static final String FILE_TYPE = "Kind";
	private static final String NAME = "Name";
	private static final String SAMPLE_RATE = "Sample Rate";
	private static final String TRACK_NO = "Track Number";	
	private static final String TIME = "Total Time";	
	private static final String TRACKS = "Tracks";
	private static final String VARIOUS = "Various Artists";
	private static final String YEAR = "Year";

	private static final String[] IGNORE_TYPES = {
			"iPad app",
			"iPhone/iPod touch app",
			"iPhone/iPod touch/iPad app",
			"iTunes Extras",
			"MPEG-4 video file",
			"Protected MPEG-4 video file",
			"Purchased MPEG-4 video file",
			"MPEG audio stream"
		};
	
	private static final List<String> IGNORE_TYPE_LIST = Arrays.asList(IGNORE_TYPES);	
	
    private static final Logger LOG = LoggerFactory.getLogger(ITunesService.class);
       
    public Map<RecordingKey, Recording> getAlbumsFromResource(String fileName) {
    	String path = PathHelper.findResourceOnClassPath(fileName);
    	return this.getAlbums(path);
    }
    	
    public Map<RecordingKey, Recording> getAlbums(String path) {
    	Map<RecordingKey, Recording> albums = new LinkedHashMap<>();
    	Collection<NSDictionary> tracks = this.getTracksFromFile(path);
    	for (NSDictionary track : tracks) {
    		Song song = this.getSongFromTrack(track);
    		if (song != null && !IGNORE_TYPE_LIST.contains(song.getFileType()) &&
    			!song.getFileName().startsWith("http://")) {
    			RecordingKey albumID = this.getAlbumIDFromTrack(track);
    			Recording album = albums.get(albumID);
    			if (album == null) {
    				boolean compilation = this.getBoolean(track, COMPILATION);
    				album = new Recording(albumID, song, compilation);
    				albums.put(albumID, album);
    			}
    			else {
    				album.addSong(song);
    			}
    		}
    	}
    	return albums;
    }
    
    protected Collection<NSDictionary> getTracksFromFile(String path) {
    	Collection<NSDictionary> tracks = new ArrayList<>();
    	try {
    		NSDictionary dictionary = (NSDictionary) PropertyListParser.parse(path);
            NSDictionary trackDictionary = (NSDictionary) dictionary.objectForKey(TRACKS);
            for (NSObject value : trackDictionary.values()) {
            	NSDictionary track = (NSDictionary) value;
            	tracks.add(track);
            }
    	}
    	catch (Exception e) {
    		LOG.error("Whoops. {}", e);
    	}
    	return tracks;
    }
    
    protected RecordingKey getAlbumIDFromTrack(NSDictionary track) {
    	boolean compilation = this.getBoolean(track, COMPILATION); 
    	String artist = compilation ? VARIOUS : this.getString(track, ARTIST);
    	String title = this.getString(track, ALBUM);
    	Integer year = this.getInteger(track, YEAR);
    	return new RecordingKey(artist, title, year);
    }

    protected Song getSongFromTrack(NSDictionary track) {
    	Song song = new Song();
    	song.setArtist(this.getString(track, ARTIST));
    	song.setBitRate(this.getInteger(track, BIT_RATE));
    	song.setComments(this.getString(track, COMMENTS));
    	song.setDiscNo(this.getInteger(track, DISC_NO));
    	song.setFileName(PathHelper.cleanPath(this.getString(track, FILE_NAME)));
    	song.setFileSize(this.getInteger(track,FILE_SIZE));
    	song.setFileType(this.getString(track,FILE_TYPE));
    	song.setName(this.getString(track, NAME));
    	song.setSampleRate(this.getInteger(track, SAMPLE_RATE));
    	song.setTimeMs(this.getInteger(track, TIME));
    	song.setTrackNo(this.getInteger(track, TRACK_NO));
    	song.setYear(this.getInteger(track, YEAR));
    	return song;
    }
    
    private Boolean getBoolean(NSDictionary dictionary, String key) {
    	Boolean b = this.getValue(dictionary, key, Boolean.class);
    	return (b == null ? new Boolean(false) : b);
    }
        
    private Integer getInteger(NSDictionary dictionary, String key) {
    	return this.getValue(dictionary, key, Integer.class);
    }
    
    private String getString(NSDictionary dictionary, String key) {
    	return this.getValue(dictionary, key, String.class);
    }
    
    private <T> T getValue(NSDictionary dictionary, String key, Class<T> c) {
    	T value = null;
    	final NSObject o = dictionary.objectForKey(key);
    	if (o != null) {
    		final Object jo = o.toJavaObject();
    		if (c.isInstance(jo)) {
    			value = c.cast(jo);
    		}
    	}
    	return value;
    }   
}
