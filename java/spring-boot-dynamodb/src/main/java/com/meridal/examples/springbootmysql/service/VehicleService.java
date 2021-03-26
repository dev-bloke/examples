package com.meridal.examples.springbootmysql.service;

import java.util.Collection;
import java.util.List;

import com.meridal.examples.springbootmysql.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.meridal.examples.springbootmysql.domain.Vehicle;
import com.meridal.examples.springbootmysql.domain.VehicleModel;

@Component
public class VehicleService {
   
    @Autowired
    private VehicleRepository repository;
 
    /**
     * Delete a vehicle.
     * @param vehicle
     */
    public void deleteVehicle(Vehicle vehicle) {
	    this.repository.delete(vehicle);
    }
    
    /**
     * Find all vehicles.
     * @return Full list of vehicles
     */
    public List<Vehicle> findAllVehicles() {
	Iterable<Vehicle> vehicles = this.repository.findAll();
	    return Lists.newArrayList(vehicles);
    }
    
    /**
     * Find a vehicle by Make and Model.
     * @param make Make
     * @param model Model
     * @return Vehicle
     */
    public Vehicle findVehicle(String make, String model) {
	VehicleModel id = new VehicleModel(make, model);
	    return this.findVehicle(id);
    }
    
    /**
     * Find a vehicle by ID.
     * @param id ID
     * @return Vehicle
     */
    public Vehicle findVehicle(VehicleModel id) {
	    return this.repository.findById(id).orElse(null);	
    }
    
    /**
     * Find all vehicles matching the collection of IDs supplied.
     * @param ids IDs
     * @return List of vehicles
     */
    public List<Vehicle> findVehicles(Collection<VehicleModel> ids) {
	Iterable<Vehicle> vehicles = this.repository.findAllById(ids);
	    return Lists.newArrayList(vehicles);
    }
    
    /**
     * Save a vehicle.
     * @param vehicle Vehicle
     */
    public void saveVehicle(Vehicle vehicle) {
	    this.repository.save(vehicle);
    }
}
