package com.meridal.examples.kotlinspringboot.controller

import com.meridal.examples.kotlinspringboot.model.Recording
import com.meridal.examples.kotlinspringboot.service.RecordingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/recording")
class RecordingController @Autowired constructor(private val service: RecordingService) {

    @GetMapping("/")
    fun getAllRecordings() = service.getAllRecordings()

    @GetMapping("/{id}")
    fun getRecording(@PathVariable id: String) = service.getRecording(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist")

    @PostMapping("/")
    fun saveRecording(@RequestBody recording: Recording): Recording = service.saveRecording(recording)

    @PutMapping("/{id}")
    fun updateRecording(@PathVariable id: String, @RequestBody recording: Recording): Recording {
        recording.id = id
        return service.saveRecording(recording)
    }

    @DeleteMapping("/{id}")
    fun deleteRecording(@PathVariable id: String) = service.deleteRecording(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist")
}