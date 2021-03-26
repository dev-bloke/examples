package com.meridal.examples.springbootmysql.springboot.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meridal.examples.springbootmysql.springboot.model.Recording;
import com.meridal.examples.springbootmysql.springboot.service.RecordingService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest
public class RecordingControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Long ID = 1234L;
    private static final String BOWIE_ARTIST = "David Bowie";
    private static final String BOWIE_TITLE = "Lodger";
    private static final String BOWIE_CAT_NO = "BOWLP1";
    private static final String GENESIS_ARTIST = "Genesis";
    private static final String GENESIS_TITLE = "Three Sides Live";
    private static final String GENESIS_CAT_NO = "GENLP1";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RecordingService service;

    private ObjectWriter jsonWriter;
    private Recording bowie;
    private Recording genesis;

    @BeforeEach
    public void setup() {
        MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        this.jsonWriter = MAPPER.writer().withDefaultPrettyPrinter();
        this.bowie = new Recording(BOWIE_ARTIST, BOWIE_TITLE, BOWIE_CAT_NO);
        this.genesis = new Recording(GENESIS_ARTIST, GENESIS_TITLE, GENESIS_CAT_NO);
    }

    @Test
    public void testGet() throws Exception {
        when (this.service.getRecording(ID)).thenReturn(this.bowie);
        this.mvc.perform(get("/api/recording/" + ID))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(BOWIE_ARTIST)))
            .andExpect(content().string(containsString(BOWIE_TITLE)))
            .andExpect(content().string(containsString(BOWIE_CAT_NO)));
    }

    @Test
    public void testGetWithInvalidID() throws Exception {
        when (this.service.getRecording(ID)).thenReturn(null);
        this.mvc.perform(get("/api/recording/" + ID))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAll() throws Exception {
        final List<Recording> recordings = Lists.newArrayList(this.bowie, this.genesis);
        when (this.service.getAllRecordings()).thenReturn(recordings);
        this.mvc.perform(get("/api/recording/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(BOWIE_ARTIST)))
            .andExpect(content().string(containsString(BOWIE_TITLE)))
            .andExpect(content().string(containsString(BOWIE_CAT_NO)))
            .andExpect(content().string(containsString(GENESIS_ARTIST)))
            .andExpect(content().string(containsString(GENESIS_TITLE)))
            .andExpect(content().string(containsString(GENESIS_CAT_NO)));
    }

    @Test
    public void testPost() throws Exception {
        final String json = jsonWriter.writeValueAsString(this.bowie);
        this.bowie.setId(ID);
        when (this.service.saveRecording(any())).thenReturn(this.bowie);
        mvc.perform(post("/api/recording/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString(BOWIE_ARTIST)))
            .andExpect(content().string(containsString(BOWIE_TITLE)))
            .andExpect(content().string(containsString(BOWIE_CAT_NO)));
    }

    @Test
    public void testPut() throws Exception {
        this.bowie.setId(ID);
        final String json = jsonWriter.writeValueAsString(this.bowie);
        when (this.service.saveRecording(any())).thenReturn(this.bowie);
        mvc.perform(put("/api/recording/" + ID)
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString(BOWIE_ARTIST)))
            .andExpect(content().string(containsString(BOWIE_TITLE)))
            .andExpect(content().string(containsString(BOWIE_CAT_NO)));
    }

    @Test
    public void testDelete() throws Exception {
        when (this.service.deleteRecording(ID)).thenReturn(this.bowie);
        this.mvc.perform(delete("/api/recording/" + ID))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(BOWIE_ARTIST)))
            .andExpect(content().string(containsString(BOWIE_TITLE)))
            .andExpect(content().string(containsString(BOWIE_CAT_NO)));
    }

    @Test
    public void testDeleteWithInvalidID() throws Exception {
        when (this.service.deleteRecording(ID)).thenReturn(null);
        this.mvc.perform(delete("/api/recording/" + ID))
            .andExpect(status().isNotFound());
    }
}