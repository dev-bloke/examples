package com.meridal.examples.recordcollection.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.meridal.examples.recordcollection.domain.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntryTest {

    private static final Integer ID = 12345678;
    private static final Integer OTHER_ID = 87654321;

    private Entry entry;
    private Entry other;

    @BeforeEach
    public void setup() {
        this.entry = new Entry(ID);
        this.other = new Entry();
    }

    @Test
    public void testHasId() {
        assertTrue(this.entry.hasId());
        assertFalse(this.other.hasId());
    }

    @Test
    public void testEqualsAndHashCodeWithTheSameID() {
        this.other.setId(ID);
        assertEquals(this.entry, this.other);
        assertEquals(this.entry.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentID() {
        this.other.setId(OTHER_ID);
        assertNotEquals(this.entry, this.other);
        assertNotEquals(this.entry.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullID() {
        assertNotEquals(this.entry, this.other);
        assertNotEquals(this.entry.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(this.entry, null);
    }

    @Test
    public void testEqualsWithAnotherType() {
        assertFalse(this.entry.equals("A string"));
    }

    @Test
    public void testToString() {
        final String string = this.entry.toString();
        assertTrue(string.contains(ID.toString()));
    }
}
