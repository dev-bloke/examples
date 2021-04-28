package com.meridal.examples.kotlinspringboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class RecordingControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var service: RecordingService
    private val mapper = ObjectMapper()
    private lateinit var jsonWriter: ObjectWriter
    private val bowie = Recording("David Bowie", "Lodger", "BOWLP1")
    private val genesis = Recording("Genesis", "Three Sides Live", "GENLP1")
    private val id = 1234L


    @BeforeEach
    fun setup() {
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        jsonWriter = mapper.writer().withDefaultPrettyPrinter()
    }

    @Test
    fun `Get all recordings returns a list of everything in the repository`() {
        every { service.getAllRecordings() } returns listOf(bowie, genesis)
        mockMvc.perform(get("/api/recording/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].artist").value(bowie.artist))
            .andExpect(jsonPath("\$.[1].artist").value(genesis.artist))
    }

    @Test
    fun `Get a recording by ID returns a recording`() {
        every { service.getRecording(id) } returns bowie
        mockMvc.perform(get("/api/recording/$id").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.artist").value(bowie.artist))
    }

    @Test
    fun `Get a recording by an invalid ID returns status not found`() {
        val nonexistent: Recording? = null
        every { service.getRecording(id) } returns nonexistent
        mockMvc.perform(get("/api/recording/$id").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `Post a recording places a new recording in the repository`() {
        val json = jsonWriter.writeValueAsString(bowie)
        val slot = slot<Recording>()
        every { service.saveRecording(recording = capture(slot)) } returns bowie
        mockMvc.perform(post("/api/recording/").contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.artist").value(bowie.artist))
        verify(exactly = 1) { service.saveRecording(any()) }
        assertThat(slot.captured.artist).isEqualTo(bowie.artist)
    }

    @Test
    fun `Put a recording updates a recording in the repository`() {
        val json = jsonWriter.writeValueAsString(bowie)
        val slot = slot<Recording>()
        every { service.saveRecording(recording = capture(slot)) } returns bowie
        mockMvc.perform(put("/api/recording/$id").contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.artist").value(bowie.artist))
        verify(exactly = 1) { service.saveRecording(any()) }
        assertThat(slot.captured.artist).isEqualTo(bowie.artist)
    }

    @Test
    fun `Delete a recording by valid ID removes a recording from the repository and returns it`() {
        every { service.deleteRecording(id) } returns bowie
        mockMvc.perform(delete("/api/recording/$id").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.artist").value(bowie.artist))
    }

    @Test
    fun `Delete a recording by an invalid ID returns status not found`() {
        val nonexistent: Recording? = null
        every { service.deleteRecording(id) } returns nonexistent
        mockMvc.perform(delete("/api/recording/$id").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
    }
}