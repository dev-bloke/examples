package com.meridal.examples.elasticsearch.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meridal.examples.elasticsearch.domain.Recording;
import com.meridal.examples.elasticsearch.service.RecordingService;

/**
 * Controller for public-facing API requests.
 * @author Martin Ingram
 */
@RestController
@RequestMapping("/api")
public class PublicAPIController {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public Recording hello() {
        Recording recording = new Recording();
        recording.setArtist("Steven Wilson");
        recording.setTitle("NSRGNTS RMXS");
        return recording;
    }

    @Autowired
    private RecordingService recordingService;


    @RequestMapping(value="/recording/all", method=RequestMethod.GET)
    @ResponseBody	
    public List<Recording> getAllRecordings() {
        return this.recordingService.findAllRecordings();
    }

    @RequestMapping(value="/recording/{id}", method=RequestMethod.GET)
    @ResponseBody	
    public Recording getRecording(@PathVariable String id) {
        return this.recordingService.findRecording(id);
    }

    @RequestMapping(value="/recording/ids/{ids}", method=RequestMethod.GET)
    @ResponseBody	
    public List<Recording> getRecordings(@PathVariable List<String> ids) {
        return this.recordingService.findRecordings(ids);
    }

    @RequestMapping(value="/recording", method=RequestMethod.POST)
    @ResponseBody
    public Recording postRecording(@RequestBody Recording recording) {
        this.recordingService.saveRecording(recording);
        return recording;
    }

    @RequestMapping(value="/recording/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Recording putRecording(@RequestBody Recording recording) {
        this.recordingService.saveRecording(recording);
        return recording;
    }    

    @RequestMapping(value="/recording", method=RequestMethod.DELETE)
    @ResponseBody
    public Recording deleteRecording(@RequestBody Recording recording) {
        this.recordingService.deleteRecording(recording);
        return recording;
    }
}
