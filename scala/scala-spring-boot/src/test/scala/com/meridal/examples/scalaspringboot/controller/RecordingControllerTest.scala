package com.meridal.examples.scalaspringboot.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.result.MockMvcResultMatchers._
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders._
import org.mockito.Mockito._
import org.hamcrest.Matchers._
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

import com.meridal.examples.scalaspringboot.model.Recording
import com.meridal.examples.scalaspringboot.service.RecordingService
import org.springframework.http.MediaType

@WebMvcTest
@RunWith(classOf[SpringRunner])
class RecordingControllerTest {

  val noman = new Recording("No-Man", "Together We're Stranger", "NOMANDVD2")
  val bowie = new Recording("David Bowie", "Earthling", "BOWCD10")
  val id = 1234L

  @Autowired
  var mvc: MockMvc = _
  
  @MockBean
  var service: RecordingService = _

  var mapper = new ObjectMapper()
  var jsonWriter: ObjectWriter = _

  @Before
  def setup(): Unit = {
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
    jsonWriter = mapper.writer().withDefaultPrettyPrinter()
  }

  @Test
  def testGet(): Unit = {
    when(service.getRecording(id)).thenReturn(noman)
    mvc.perform(get("/api/recording/" + id))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("No-Man")))
  }

  @Test
  def testGetWithInvalidID(): Unit = {
    when(service.getRecording(id)).thenReturn(null)
    mvc.perform(get("/api/recording/" + id))
      .andExpect(status().isNotFound())
  }

  @Test
  def testGetAll(): Unit = {
    when(service.getAllRecordings()).thenReturn(List(bowie, noman))
    mvc.perform(get("/api/recording/"))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("No-Man")))
      .andExpect(content().string(containsString("David Bowie")))
  }

  @Test
  def testPost(): Unit = {
     val json = jsonWriter.writeValueAsString(bowie)
     when(service.saveRecording(any(classOf[Recording]))).thenReturn(bowie)
     mvc.perform(post("/api/recording/")
      .contentType(MediaType.APPLICATION_JSON)
      .content(json))
      .andExpect(status().isOk)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string(containsString("David Bowie")))
  }

  @Test
  def testDelete(): Unit = {
    when(service.deleteRecording(id)).thenReturn(noman)
    mvc.perform(delete("/api/recording/" + id))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("No-Man")))
  }

  @Test
  def testDeleteWithInvalidID(): Unit = {
    when(service.deleteRecording(id)).thenReturn(null)
    mvc.perform(get("/api/recording/" + id))
      .andExpect(status().isNotFound())
  }
}
