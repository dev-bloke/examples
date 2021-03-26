package com.meridal.examples.springboot.controller;

import com.meridal.examples.springboot.model.Recording;
import com.meridal.examples.springboot.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/recording")
public class RecordingController {

    private RecordingService service;

    public RecordingController(@Autowired final RecordingService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Recording> getAllRecordings() {
        return this.service.getAllRecordings();
    }

    @GetMapping("/{id}")
    public Recording getRecording(@PathVariable Long id) {
        final Recording recording = this.service.getRecording(id);
        if (recording == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist.");
        }
        return recording;
    }

    @PostMapping("/")
    public Recording saveRecording(@RequestBody Recording recording) {
        return this.service.saveRecording(recording);
    }

    @PutMapping("/{id}")
    public Recording updateRecording(@PathVariable Long id, @RequestBody Recording recording) {
        recording.setId(id);
        return this.service.saveRecording(recording);
    }

    @DeleteMapping("/{id}")
    public Recording deleteRecording(@PathVariable Long id) {
        final Recording recording = this.service.deleteRecording(id);
        if (recording == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist.");
        }
        return recording;
    }
}
