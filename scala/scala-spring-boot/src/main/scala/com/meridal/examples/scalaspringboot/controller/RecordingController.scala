package com.meridal.examples.scalaspringboot.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

import scala.collection.JavaConverters._

import com.meridal.examples.scalaspringboot.model.Recording
import com.meridal.examples.scalaspringboot.service.RecordingService


@RestController
@RequestMapping(Array("/api/recording"))
class RecordingController(@Autowired val service: RecordingService) {

  @GetMapping(Array("/"))
  def getAllRecordings() = service.getAllRecordings().asJava

  @GetMapping(Array("/{id}"))
  def getRecording(@PathVariable id: Long): Recording = { 
    val recording = service.getRecording(id)
    if (recording == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist")
    }
    return recording
  }

  @PostMapping(Array("/"))
  def saveRecording(@RequestBody recording: Recording) = service.saveRecording(recording)

  @PutMapping(Array("/{id}"))
  def updateRecording(@PathVariable id: Long, @RequestBody recording: Recording): Recording = {
    recording.id = id
    service.saveRecording(recording)
  }

  @DeleteMapping(Array("/{id}"))
  def deleteRecording(@PathVariable id: Long): Recording = {
    val recording = service.deleteRecording(id)
    if (recording == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist") 
    }
    return recording
  } 
}
