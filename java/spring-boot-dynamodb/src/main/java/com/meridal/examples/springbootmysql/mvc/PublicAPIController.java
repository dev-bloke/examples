package com.meridal.examples.springbootmysql.mvc;

import java.util.List;

import com.meridal.examples.springbootmysql.domain.Recording;
import com.meridal.examples.springbootmysql.domain.Vehicle;
import com.meridal.examples.springbootmysql.domain.VehicleModel;
import com.meridal.examples.springbootmysql.service.RecordingService;
import com.meridal.examples.springbootmysql.service.VehicleService;
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
    private RecordingService recordingService;
    
    @Autowired
    private VehicleService vehicleService;

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
	this.recordingService.saveRecording(recording);
	return recording;
    }
    
    @RequestMapping(value="/vehicle/all", method=RequestMethod.GET)
    @ResponseBody	
    public List<Vehicle> getAllVehicles() {
	return this.vehicleService.findAllVehicles();
    }
    
    @RequestMapping(value="/vehicle/{make}/{model}", method=RequestMethod.GET)
    @ResponseBody	
    public Vehicle getVehicle(@PathVariable String make, @PathVariable String model) {
	return this.vehicleService.findVehicle(make, model);
    }
    
    @RequestMapping(value="/vehicle/ids", method=RequestMethod.GET)
    @ResponseBody	
    public List<Vehicle> getVehicles(@RequestBody List<VehicleModel> ids) {
	return this.vehicleService.findVehicles(ids);
    }
    
    @RequestMapping(value="/vehicle", method=RequestMethod.POST)
    @ResponseBody
    public Vehicle postVehicle(@RequestBody Vehicle vehicle) {
	this.vehicleService.saveVehicle(vehicle);
	return vehicle;
    }

    @RequestMapping(value="/vehicle/{make}/{model}", method=RequestMethod.PUT)
    @ResponseBody
    public Vehicle putVehicle(@RequestBody Vehicle vehicle) {
	this.vehicleService.saveVehicle(vehicle);
	return vehicle;
    }    
    
    @RequestMapping(value="/vehicle", method=RequestMethod.DELETE)
    @ResponseBody
    public Vehicle deleteVehicle(@RequestBody Vehicle vehicle) {
	this.vehicleService.saveVehicle(vehicle);
	return vehicle;
    }
}
