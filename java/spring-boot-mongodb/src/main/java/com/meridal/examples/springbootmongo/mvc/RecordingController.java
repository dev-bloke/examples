package com.meridal.examples.springbootmongo.mvc;

import com.meridal.examples.springbootmongo.domain.Recording;
import com.meridal.examples.springbootmongo.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Controller for public-facing API requests.
 * @author Martin Ingram
 */
@RestController
@RequestMapping("/api/recording")
public class RecordingController {

    @Autowired
    private RecordingService service;

    @GetMapping("/")
    public List<Recording> getAllRecordings(@RequestParam(required=false) Optional<List<String>> ids) {
        return (ids.isPresent()) ? this.service.getRecordings(ids.get()) : this.service.getAllRecordings();
    }

    @GetMapping("/{id}")
    public Recording getRecording(@PathVariable String id) {
        final Recording recording = this.service.getRecording(id);
        this.checkRecordingExists(recording);
        return recording;
    }

    @PostMapping("/")
    public Recording postRecording(@RequestBody Recording recording) {
        return this.service.saveRecording(recording);
    }

    @PutMapping("/{id}")
    public Recording putRecording(@PathVariable String id, @RequestBody Recording recording) {
        recording.setId(id);
        return this.service.saveRecording(recording);
    }

    @DeleteMapping("/{id}")
    public Recording deleteRecording(@PathVariable String id) {
        final Recording recording = this.service.deleteRecording(id);
        this.checkRecordingExists(recording);
        return recording;
    }

    private void checkRecordingExists(final Recording recording) {
        if (recording == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This recording does not exist.");
        }
    }
}
