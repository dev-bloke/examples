package com.meridal.examples.springbootmysql.domain;

import com.meridal.examples.springbootmysql.test.TestFramework;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SongTest extends TestFramework {

        private static final Integer ID = 1234;
        private static final Integer OTHER_ID = 5678;

        @Test
        public void testEqualsAndHashCodeWithSameID() {
            final Song song = this.randomSong(ID);
            final Song other = this.cloneSong(ID, song);
            assertEquals(song, other);
            assertEquals(song.hashCode(), other.hashCode());
        }

        @Test
        public void testEqualsAndHashCodeWithDifferentID() {
            final Song song = this.randomSong(ID);
            final Song other = this.cloneSong(OTHER_ID, song);
            assertNotEquals(song, other);
            assertNotEquals(song.hashCode(), other.hashCode());
        }

        @Test
        public void testEqualsAndHashCodeWithNullID() {
            final Song song = this.randomSong();
            final Song other = this.cloneSong(ID, song);
            assertNotEquals(song, other);
            assertNotEquals(song.hashCode(), other.hashCode());
        }

        @Test
        public void testEqualsAndHashCodeWithBothIDsNull() {
            final Song song = this.randomSong();
            final Song other = this.cloneSong(null, song);
            assertNotEquals(song, other);
            assertEquals(song.hashCode(), other.hashCode());
        }

        @Test
        public void testEqualsWithAnotherType() {
            final Song song = this.randomSong();
            final List<Integer> other = new ArrayList<>();
            assertFalse(song.equals(other));
        }

        @Test
        public void testEqualsWithNull() {
            final Song song = this.randomSong();
            assertFalse(song.equals(null));
        }
}
