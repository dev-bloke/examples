package com.meridal.examples.springbootmysql.mvc;

import java.util.List;

import com.meridal.examples.springbootmysql.domain.Recording;
import com.meridal.examples.springbootmysql.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for public-facing API requests.
 * @author Martin Ingram
 */
@RestController
@RequestMapping("/api")
public class PublicAPIController {
    
    @Autowired
    private RecordingService service;

    @RequestMapping(value="/recording/all", method=RequestMethod.GET)
    @ResponseBody	
    public List<Recording> getAllRecordings() {
    	return this.service.findAllRecordings();
    }

    @RequestMapping(value="/recording/{id}", method=RequestMethod.GET)
    @ResponseBody	
    public Recording getRecording(@PathVariable String id) {
    	return this.service.findRecording(id);
    }

    @RequestMapping(value="/recording/ids/{ids}", method=RequestMethod.GET)
    @ResponseBody	
    public List<Recording> getRecordings(@PathVariable List<String> ids) {
    	return this.service.findRecordings(ids);
    }

    @RequestMapping(value="/recording", method=RequestMethod.POST)
    @ResponseBody
    public Recording postRecording(@RequestBody Recording recording) {
    	this.service.saveRecording(recording);
    	return recording;
    }

    @RequestMapping(value="/recording/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Recording putRecording(@RequestBody Recording recording) {
    	this.service.saveRecording(recording);
    	return recording;
    }    

    @RequestMapping(value="/recording", method=RequestMethod.DELETE)
    @ResponseBody
    public Recording deleteRecording(@RequestBody Recording recording) {
    	this.service.saveRecording(recording);
    	return recording;
    }
}
