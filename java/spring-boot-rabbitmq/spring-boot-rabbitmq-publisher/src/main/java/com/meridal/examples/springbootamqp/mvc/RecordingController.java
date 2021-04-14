package com.meridal.examples.springbootamqp.mvc;

import com.meridal.examples.springbootamqp.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recording")
public class RecordingController {

    @Autowired
    private RecordingService service;

    @GetMapping("/{id}")
    public String getRecording(@PathVariable String id) {
        this.service.publishRecording(id);
        return "success";
    }
}
