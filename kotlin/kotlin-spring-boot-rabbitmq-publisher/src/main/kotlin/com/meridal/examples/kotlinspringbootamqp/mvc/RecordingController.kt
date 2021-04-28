package com.meridal.examples.kotlinspringbootamqp.mvc

import com.meridal.examples.domain.Recording
import com.meridal.examples.kotlinspringbootamqp.service.RecordingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/recording")
class RecordingController @Autowired constructor(private val service: RecordingService) {

    @PostMapping("/")
    fun saveRecording(@RequestBody recording: Recording): Recording? {
        service.publishRecording(recording)
        return recording
    }
}