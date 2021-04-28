package com.meridal.examples.kotlinspringbootamqp.mvc

import com.meridal.examples.domain.Recording
import com.meridal.examples.kotlinspringbootamqp.service.RecordingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/recording")
class RecordingController @Autowired constructor(private val service: RecordingService) {

    @GetMapping("/")
    fun getAllRecordings(): List<Recording>? {
        return service.getAllRecordings()
    }
}