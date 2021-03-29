package com.meridal.examples.springbootelasticsearch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.meridal.examples.springbootelasticsearch.domain.Recording;
import com.meridal.examples.springbootelasticsearch.repository.RecordingRepository;
import com.meridal.examples.springbootelasticsearch.test.TestFramework;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecordingServiceTest extends TestFramework {

    private static final String ID = "1234";
    private static final String OTHER_ID = "5678";

    private Recording recording;
    private Recording otherRecording;
    private List<Recording> recordings;

    private RecordingService service;
    private RecordingRepository repository;

    @BeforeEach
    public void setup() {
        this.recording = this.randomRecording(ID);
        this.otherRecording = this.randomRecording(OTHER_ID);
        this.recordings = Arrays.asList(recording, otherRecording);
        this.repository = mock(RecordingRepository.class);
        this.service = new RecordingService(this.repository);
    }

    @Test
    public void testGetAllRecordings() {
        when (repository.findAll()).thenReturn(recordings);
        final List<Recording> found = this.service.getAllRecordings();
        assertTrue(found.contains(recording));
        assertTrue(found.contains(otherRecording));
    }

    @Test
    public void testGetRecording() {
        when (repository.findById(ID)).thenReturn(Optional.of(recording));
        final Recording found = this.service.getRecording(ID);
        assertEquals(recording, found);
    }

    @Test
    public void testGetRecordingWithInvalidID() {
        when (repository.findById(ID)).thenReturn(Optional.empty());
        final Recording found = this.service.getRecording(ID);
        assertNull(found);
    }

    @Test
    public void testGetRecordingsByID() {
        final List<String> ids = Arrays.asList(ID, OTHER_ID);
        when (repository.findAllById(ids)).thenReturn(this.recordings);
        final List<Recording> found = this.service.getRecordings(ids);
        assertTrue(found.contains(recording));
        assertTrue(found.contains(otherRecording));
    }

    @Test
    public void testSaveRecording() {
        when (repository.save(this.recording)).thenReturn(this.recording);
        final Recording saved = this.service.saveRecording(this.recording);
        assertEquals(this.recording, saved);
    }

    @Test
    public void testDeleteRecording() {
        when (repository.findById(ID)).thenReturn(Optional.of(recording));
        final Recording deleted = this.service.deleteRecording(ID);
        assertEquals(this.recording, deleted);
        verify(this.repository, times(1)).deleteById(ID);
    }

    @Test
    public void testDeleteRecordingWithInvalidID() {
        when (repository.findById(ID)).thenReturn(Optional.empty());
        final Recording deleted = this.service.deleteRecording(ID);
        assertNull(deleted);
        verify(this.repository, times(0)).deleteById(ID);
    }
}
