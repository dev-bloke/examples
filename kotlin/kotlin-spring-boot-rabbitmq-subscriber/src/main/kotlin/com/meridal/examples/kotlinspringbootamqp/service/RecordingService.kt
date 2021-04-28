package com.meridal.examples.kotlinspringbootamqp.service

import com.meridal.examples.domain.Recording
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RecordingService {

    private val LOG: Logger = LoggerFactory.getLogger(RecordingService::class.java)

    private val recordings: MutableList<Recording> = mutableListOf()

    fun getAllRecordings(): List<Recording> {
        return recordings
    }

    @RabbitListener(queues = ["\${messaging.queue}"])
    fun saveRecording(recording: Recording) {
        recordings.add(recording)
        LOG.info("Received message: $recording")
    }
}