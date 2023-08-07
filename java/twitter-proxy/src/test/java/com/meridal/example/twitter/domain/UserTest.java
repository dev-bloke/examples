package com.meridal.example.twitter.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static final String USERNAME = "davidbowieofficial";
    private static final String NAME = "David Bowie";
    private static final String ID = "12345678";
    private static final String OTHER_ID = "87654321";

    private User user;
    private User other;

    @BeforeEach
    public void setup() {
        this.user = new User(USERNAME, NAME);
        this.user.setId(ID);
        this.other = new User(USERNAME, NAME);
    }

    @Test
    public void testHasId() {
        assertTrue(this.user.hasId());
        assertFalse(this.other.hasId());
    }

    @Test
    public void testEqualsAndHashCodeWithTheSameID() {
        this.other.setId(ID);
        assertEquals(this.user, this.other);
        assertEquals(this.user.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentID() {
        this.other.setId(OTHER_ID);
        assertNotEquals(this.user, this.other);
        assertNotEquals(this.user.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullID() {
        assertNotEquals(this.user, this.other);
        assertNotEquals(this.user.hashCode(), this.other.hashCode());
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(this.user, null);
    }

    @Test
    public void testEqualsWithAnotherType() {
        assertFalse(this.user.equals("A string"));
    }

    @Test
    public void testToString() {
        final String string = this.user.toString();
        assertTrue(string.contains(ID));
        assertTrue(string.contains(USERNAME));
        assertTrue(string.contains(NAME));
    }
}

