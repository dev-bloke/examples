package com.meridal.examples.springbootmongo.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.meridal.examples.springbootmongo.domain.Recording;
import com.meridal.examples.springbootmongo.domain.Song;
import com.meridal.examples.springbootmongo.service.RecordingService;
import com.meridal.examples.springbootmongo.test.TestFramework;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class RecordingControllerTest extends TestFramework {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String ID = "1234";
    private static final String OTHER_ID = "5678";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RecordingService service;

    private ObjectWriter jsonWriter;

    private Recording recording;
    private Recording otherRecording;
    private Song song;
    private Song otherSong;

    @BeforeEach
    public void setup() {
        MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        this.jsonWriter = MAPPER.writer().withDefaultPrettyPrinter();
        this.recording = this.randomRecording();
        this.otherRecording = this.randomRecording();
        this.song = this.recording.getSongs().get(0);
        this.otherSong = this.otherRecording.getSongs().get(0);
    }

    @Test
    public void testGet() throws Exception {
        this.recording.setId(ID);
        when (this.service.getRecording(ID)).thenReturn(this.recording);
        this.mvc.perform(get("/api/recording/" + ID))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())));
    }

    @Test
    public void testGetWithInvalidID() throws Exception {
        when (this.service.getRecording(ID)).thenReturn(null);
        this.mvc.perform(get("/api/recording/" + ID))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAll() throws Exception {
        final List<Recording> recordings = Lists.newArrayList(this.recording, this.otherRecording);
        when (this.service.getAllRecordings()).thenReturn(recordings);
        this.mvc.perform(get("/api/recording/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())))
            .andExpect(content().string(containsString(this.otherRecording.getArtist())))
            .andExpect(content().string(containsString(this.otherRecording.getTitle())))
            .andExpect(content().string(containsString(this.otherRecording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.otherSong.getTitle())))
            .andExpect(content().string(containsString(this.otherSong.getDuration())));
    }

    @Test
    public void testGetAllWithIds() throws Exception {
        final List<Recording> recordings = Lists.newArrayList(this.recording, this.otherRecording);
        final List<String> ids = Lists.newArrayList(ID, OTHER_ID);
        when (this.service.getRecordings(ids)).thenReturn(recordings);
        this.mvc.perform(get("/api/recording/?ids=" + ID + "," + OTHER_ID))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())))
            .andExpect(content().string(containsString(this.otherRecording.getArtist())))
            .andExpect(content().string(containsString(this.otherRecording.getTitle())))
            .andExpect(content().string(containsString(this.otherRecording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.otherSong.getTitle())))
            .andExpect(content().string(containsString(this.otherSong.getDuration())));
    }

    @Test
    public void testPost() throws Exception {
        final String json = jsonWriter.writeValueAsString(this.recording);
        this.recording.setId(ID);
        when (this.service.saveRecording(any())).thenReturn(this.recording);
        mvc.perform(post("/api/recording/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())));
    }

    @Test
    public void testPut() throws Exception {
        this.recording.setId(ID);
        final String json = jsonWriter.writeValueAsString(this.recording);
        when (this.service.saveRecording(any())).thenReturn(this.recording);
        mvc.perform(put("/api/recording/" + ID)
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())));
    }

    @Test
    public void testDelete() throws Exception {
        when (this.service.deleteRecording(ID)).thenReturn(this.recording);
        this.mvc.perform(delete("/api/recording/" + ID))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(this.recording.getArtist())))
            .andExpect(content().string(containsString(this.recording.getTitle())))
            .andExpect(content().string(containsString(this.recording.getCatalogueNumber())))
            .andExpect(content().string(containsString(this.song.getTitle())))
            .andExpect(content().string(containsString(this.song.getDuration())));
    }

    @Test
    public void testDeleteWithInvalidID() throws Exception {
        when (this.service.deleteRecording(ID)).thenReturn(null);
        this.mvc.perform(delete("/api/recording/" + ID))
            .andExpect(status().isNotFound());
    }
}
