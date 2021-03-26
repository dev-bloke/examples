package com.meridal.examples.springbootmongo.domain;

import com.meridal.examples.springbootmongo.test.TestFramework;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RecordingTest extends TestFramework {

    private static final String ID = "1234";
    private static final String OTHER_ID = "5678";

    @Test
    public void testEqualsAndHashCodeWithSameID() {
        final Recording recording = this.randomRecording(ID);
        final Recording other = this.cloneRecording(ID, recording);
        assertEquals(recording, other);
        assertEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentID() {
        final Recording recording = this.randomRecording(ID);
        final Recording other = this.cloneRecording(OTHER_ID, recording);
        assertNotEquals(recording, other);
        assertNotEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullID() {
        final Recording recording = this.randomRecording();
        final Recording other = this.cloneRecording(ID, recording);
        assertNotEquals(recording, other);
        assertNotEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithBothIDsNull() {
        final Recording recording = this.randomRecording();
        final Recording other = this.cloneRecording(null, recording);
        assertNotEquals(recording, other);
        assertEquals(recording.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsWithAnotherType() {
        final Recording recording = this.randomRecording();
        final List<Integer> other = new ArrayList<>();
        assertFalse(recording.equals(other));
   }

    @Test
    public void testEqualsWithNull() {
        final Recording recording = this.randomRecording();
        assertFalse(recording.equals(null));
    }
}
