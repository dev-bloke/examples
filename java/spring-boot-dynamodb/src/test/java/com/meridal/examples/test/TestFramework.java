package com.meridal.examples.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.meridal.examples.domain.Recording;
import com.meridal.examples.domain.Song;
import com.meridal.examples.domain.Vehicle;
import com.meridal.examples.domain.VehicleModel;

public abstract class TestFramework {

    private static final String ARTIST = "Yes";
    private static final String TITLE =  "Close To The Edge";
    protected static final Integer WRONG_YEAR = 1971;
    protected static final Integer YEAR = 1972;
    
    private static final String[] SONGS = { "Close To The Edge", "And You And I", "Siberian Khatru" };
    private static final String[] TIMES = { "18:12", "10:40", "9:50" };
    
    private static final String MAKE = "Land Rover";
    private static final String MODEL = "Freelander 2";
    protected static final Integer WRONG_DOORS = 5;
    protected static final Integer DOORS = 4;
    private static final String TYPE = "SUV";
    
    private static final int TRACKS = SONGS.length;
    
    private Random random = new Random();
    
    protected Recording createRecording() {
	Recording recording = new Recording();
	recording.setArtist(ARTIST);
	recording.setTitle(TITLE);
	recording.setYear(WRONG_YEAR);
	List<Song> songs = new ArrayList<>();
	for (int i = 0; i < TRACKS; i++) {
	    Song song = new Song();
	    song.setTitle(SONGS[i]);
	    song.setDuration(TIMES[i]);
	    songs.add(song);
	}
	recording.setSongs(songs);
	return recording;
    }
    
    protected void checkRecording(Recording recording, Integer year) {
	assertNotNull(recording);
	assertEquals(ARTIST, recording.getArtist());
	assertEquals(TITLE, recording.getTitle());
	assertEquals(year, recording.getYear());
	List<Song> songs = recording.getSongs();
	assertNotNull(songs);
	assertEquals(TRACKS, songs.size());
	for (int i = 0; i < TRACKS; i++) {
	    Song song = songs.get(i);
	    assertNotNull(song);
	    assertEquals(SONGS[i], song.getTitle());
	    assertEquals(TIMES[i], song.getDuration());
	}
    }
    
    protected Vehicle createVehicle() {
	VehicleModel id = new VehicleModel(MAKE, MODEL);
	Vehicle vehicle = new Vehicle(id);
	vehicle.setDoors(WRONG_DOORS);
	vehicle.setType(TYPE);
	return vehicle;
    }
    
    protected void checkVehicle(Vehicle vehicle, Integer doors) {
	assertNotNull(vehicle);
	assertEquals(MAKE, vehicle.getMake());
	assertEquals(MODEL, vehicle.getModel());
	assertEquals(doors, vehicle.getDoors());
        assertEquals(TYPE, vehicle.getType());
    }
    
    protected Recording randomRecording() {
	Recording recording = new Recording();
	recording.setArtist(RandomStringUtils.randomAscii(16));
	recording.setTitle(RandomStringUtils.randomAscii(64));
	recording.setYear(1965 + (random.nextInt() % 50));
	int tracks = random.nextInt() % 20;
	List<Song> songs = new ArrayList<>();
	for (int i = 0; i < tracks; i++) {
	    songs.add(this.randomSong());
	}
	recording.setSongs(songs);
	return recording;
    }

    protected Song randomSong() {
	Song song = new Song();
	song.setTitle(RandomStringUtils.randomAscii(64));
	String mins = Integer.toString(random.nextInt() % 20);
	String secs = Integer.toString(random.nextInt() % 60);
	song.setDuration(mins + ":" + secs);
	return song;
    }
    
    protected Vehicle randomVehicle() {
	String make = RandomStringUtils.randomAscii(16);
	String model = RandomStringUtils.randomAscii(32);
	VehicleModel id = new VehicleModel(make, model);
	Vehicle vehicle = new Vehicle(id);
	vehicle.setDoors(random.nextInt() % 8);
	vehicle.setType(RandomStringUtils.randomAscii(8));
	return vehicle;	
    }
}
