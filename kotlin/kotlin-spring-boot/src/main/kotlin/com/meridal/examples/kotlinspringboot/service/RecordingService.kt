package com.meridal.examples.kotlinspringboot.service

import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.repository.RecordingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RecordingService @Autowired constructor(private val repository: RecordingRepository) {

    fun getRecording(id: Long) = repository.findByIdOrNull(id)

    fun getAllRecordings() = repository.findAll()

    fun saveRecording(recording: Recording) = repository.save(recording)

    fun deleteRecording(id: Long): Recording? {
        val recording = getRecording(id)
        if (recording != null) {
            repository.deleteById(id)
        }
        return recording
    }

}