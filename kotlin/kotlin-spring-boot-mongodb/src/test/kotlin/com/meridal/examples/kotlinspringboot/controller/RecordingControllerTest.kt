package com.meridal.examples.kotlinspringboot.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationFeature
import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.service.RecordingService
import com.meridal.examples.kotlinspringboot.test.TestFramework
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class RecordingControllerTest(@Autowired val mockMvc: MockMvc): TestFramework() {

    private val ID = "1234"
    private val OTHER_ID = "5678"

    @MockkBean
    private lateinit var service: RecordingService
    private val mapper = ObjectMapper()
    private lateinit var jsonWriter: ObjectWriter

    private val recording = randomRecording(ID)
    private val other = randomRecording(OTHER_ID)
    private val recordings = listOf(recording, other)
    private val ids = listOf(ID, OTHER_ID)

    @BeforeEach
    fun setup() {
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        jsonWriter = mapper.writer().withDefaultPrettyPrinter()
    }

    @Test
    fun `Get all recordings returns a list of everything in the repository`() {
        every { service.getAllRecordings() } returns recordings
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recording/").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.[0].artist").value(recording.artist))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.[1].artist").value(other.artist))
    }

    @Test
    fun `Get a recording by ID returns a recording`() {
        every { service.getRecording(ID) } returns recording
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recording/$ID").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.artist").value(recording.artist))
    }

    @Test
    fun `Get a recording by an invalid ID returns status not found`() {
        val nonexistent: Recording? = null
        every { service.getRecording(ID) } returns nonexistent
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recording/$ID").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `Post a recording places a new recording in the repository`() {
        val json = jsonWriter.writeValueAsString(recording)
        val slot = slot<Recording>()
        every { service.saveRecording(recording = capture(slot)) } returns recording
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/recording/").contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.artist").value(recording.artist))
        verify(exactly = 1) { service.saveRecording(any()) }
        Assertions.assertThat(slot.captured.artist).isEqualTo(recording.artist)
    }

    @Test
    fun `Put a recording updates a recording in the repository`() {
        val json = jsonWriter.writeValueAsString(recording)
        val slot = slot<Recording>()
        every { service.saveRecording(recording = capture(slot)) } returns recording
        mockMvc.perform(
            MockMvcRequestBuilders.put("/api/recording/$ID").contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.artist").value(recording.artist))
        verify(exactly = 1) { service.saveRecording(any()) }
        Assertions.assertThat(slot.captured.artist).isEqualTo(recording.artist)
    }

    @Test
    fun `Delete a recording by valid ID removes a recording from the repository and returns it`() {
        every { service.deleteRecording(ID) } returns recording
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/recording/$ID").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.artist").value(recording.artist))
    }

    @Test
    fun `Delete a recording by an invalid ID returns status not found`() {
        val nonexistent: Recording? = null
        every { service.deleteRecording(ID) } returns nonexistent
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/recording/$ID").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }
}