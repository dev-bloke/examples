package com.meridal.itunes.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.dd.plist.NSDictionary;
import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.RecordingKey;
import com.meridal.itunes.domain.Song;
import com.meridal.itunes.helper.PathHelper;

public class ITunesServiceTest {
    
    private static final String FILE = "/Library.xml";
    private static final Logger LOG = LoggerFactory.getLogger(ITunesServiceTest.class);
    
    private ITunesService service = new ITunesService();
    
    @Test
    public void testGetTracksFromFile() {
	    String path = PathHelper.findResourceOnClassPath(FILE);
	    Collection<NSDictionary> tracks = this.service.getTracksFromFile(path);
	    assertNotNull(tracks);
	    assertTrue(tracks.size() > 0);
    }
    
    @Test
    public void testGetSongFromTrack() {
	    String path = PathHelper.findResourceOnClassPath(FILE);
	    Collection<NSDictionary> tracks = this.service.getTracksFromFile(path);
	    List<NSDictionary> trackList = new ArrayList<>(tracks);
	    Song song = this.service.getSongFromTrack(trackList.get(0));
	    LOG.debug("song={}", song);
	    assertNotNull(song);
    }
    
    @Test
    public void testGetAlbumIDFromTrack() {
	    String path = PathHelper.findResourceOnClassPath(FILE);
	    Collection<NSDictionary> tracks = this.service.getTracksFromFile(path);
	    List<NSDictionary> trackList = new ArrayList<>(tracks);
	    RecordingKey id = this.service.getAlbumIDFromTrack(trackList.get(0));
	    LOG.debug("albumID={}", id);
	    assertNotNull(id);
    }
    
    @Test
    public void testGetAlbumsFromResource() {
	    Map<RecordingKey, Recording> albums = this.service.getAlbumsFromResource(FILE);
	    assertNotNull(albums);
	    assertTrue(albums.size() > 0);
	    LOG.debug("albums={}", albums);
    }
    
}
