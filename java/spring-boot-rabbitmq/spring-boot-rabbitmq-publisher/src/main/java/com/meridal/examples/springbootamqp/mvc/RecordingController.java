package com.meridal.examples.springbootamqp.mvc;

import com.meridal.examples.springbootamqp.service.RecordingService;
import com.meridal.examples.springbootrabbitmq.domain.Recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recording")
public class RecordingController {

    @Autowired
    private RecordingService service;

    @PostMapping("/")
    public Recording saveRecording(@RequestBody Recording recording) {
        this.service.publishRecording(recording);
        return recording;
    }
}
