package com.meridal.examples.scalaspringboot.service

import org.springframework.beans.factory.annotation.Autowired
import com.meridal.examples.scalaspringboot.repository.RecordingRepository
import org.springframework.stereotype.Service
import com.meridal.examples.scalaspringboot.model.Recording

import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters._


@Service
class RecordingService(@Autowired val repository: RecordingRepository) {
  
  def getRecording(id: Long): Recording = repository.findById(id).orElse(null)

  def getAllRecordings(): List[Recording] = ListBuffer.from(repository.findAll().asScala).result()

  def saveRecording(recording: Recording) = repository.save(recording)

  def deleteRecording(id: Long): Recording = {
    val recording = getRecording(id)
    if (recording != null) {
      repository.deleteById(id)
    }
    return recording
  }
}
