package com.meridal.examples.kotlinspringbootamqp.service

import com.meridal.examples.domain.Recording
import com.meridal.examples.kotlinspringbootamqp.repository.RecordingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecordingService @Autowired constructor(private val repository: RecordingRepository) {

    fun publishRecording(recording: Recording) {
        repository.publish(recording)
    }
}