package com.meridal.examples.springbootmysql.springboot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecordingTest {

    private static final String ARTIST = "David Bowie";
    private static final String TITLE = "Lodger";
    private static final String CAT_NO = "BOWLP1";
    private static final Long ID = 1234L;
    private static final Long OTHER_ID = 5678L;

    private Recording recording;
    private Recording other;

    @BeforeEach
    public void setup() {
        this.recording = new Recording(ARTIST, TITLE, CAT_NO);
        this.recording.setId(ID);
        this.other = new Recording(ARTIST, TITLE, CAT_NO);
    }

    @Test
    public void testEqualsAndHashCodeWithTheSameID() {
        this.other.setId(ID);
        assertEquals(this.recording, this.other);
        assertEquals(this.recording.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentID() {
        this.other.setId(OTHER_ID);
        assertNotEquals(this.recording, this.other);
        assertNotEquals(this.recording.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullID() {
        assertNotEquals(this.recording, this.other);
        assertNotEquals(this.recording.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(this.recording, null);
    }

    @Test
    public void testEqualsWithAnotherType() {
        assertFalse(this.recording.equals("A string"));
    }

    @Test
    public void testToString() {
        final String string = this.recording.toString();
        assertTrue(string.contains(ID.toString()));
        assertTrue(string.contains(ARTIST));
        assertTrue(string.contains(TITLE));
        assertTrue(string.contains(CAT_NO));
    }
}
