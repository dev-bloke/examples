package com.meridal.examples.springbootamqp.mvc;

import com.meridal.examples.springbootamqp.service.RecordingService;
import com.meridal.examples.springbootrabbitmq.domain.Recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recording")
public class RecordingController {

    @Autowired
    private RecordingService service;

    @GetMapping("/")
    public List<Recording> getAllRecordings() {
        return this.service.getAllRecordings();
    }
}
