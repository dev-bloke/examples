package com.meridal.examples.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.meridal.examples.SpringBootDynamoDB;
import com.meridal.examples.domain.Vehicle;
import com.meridal.examples.domain.VehicleModel;
import com.meridal.examples.test.TestFramework;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootDynamoDB.class)
@WebIntegrationTest
public class VehicleServiceIT extends TestFramework {
    
    private static final int COUNT = 3;

    @Autowired
    private VehicleService service;
    
    @Test
    public void testCRUD() {
	Vehicle vehicle = this.createVehicle();
	this.service.saveVehicle(vehicle);
	VehicleModel id = vehicle.getId();
	assertNotNull(id);
	Vehicle other = this.service.findVehicle(id);
	this.checkVehicle(other, WRONG_DOORS);
	vehicle.setDoors(DOORS);
	this.service.saveVehicle(vehicle);
	other = this.service.findVehicle(id);
	this.checkVehicle(other, DOORS);
	this.service.deleteVehicle(vehicle);
	other = this.service.findVehicle(id);
	assertNull(other);
    }
    
    @Test
    public void testFindVehiclesWithIDs() {
	List<VehicleModel> ids = new ArrayList<>();
	List<Vehicle> vehicles = new ArrayList<>();
	for (int i = 0; i < COUNT; i++) {
	    Vehicle vehicle = this.randomVehicle();
	    this.service.saveVehicle(vehicle);
	    ids.add(vehicle.getId());
	    vehicles.add(vehicle);
	}
	List<Vehicle> found = this.service.findVehicles(ids);
	assertEquals(COUNT, found.size());
	ids.remove(COUNT - 1);
	found = this.service.findVehicles(ids);
	assertEquals(COUNT - 1, found.size());
	VehicleModel id = this.randomVehicle().getId();
	ids.add(id);
	found = this.service.findVehicles(ids);
	assertEquals(COUNT - 1, found.size());
	for (int i = 0; i < COUNT; i++) {
	    this.service.deleteVehicle(vehicles.get(i));
	}
	found = this.service.findVehicles(ids);
	assertTrue(found.isEmpty());
    }
    
    @Test
    public void testFindAllVehicles() {
	List<VehicleModel> ids = new ArrayList<>();
	List<Vehicle> vehicles = new ArrayList<>();
	for (int i = 0; i < COUNT; i++) {
	    Vehicle vehicle = this.randomVehicle();
	    this.service.saveVehicle(vehicle);
	    ids.add(vehicle.getId());
	    vehicles.add(vehicle);
	}
	List<Vehicle> found = this.service.findAllVehicles();
	assertTrue(found.size() >= COUNT);
	for (int i = 0; i < COUNT; i++) {
	    this.service.deleteVehicle(vehicles.get(i));
	}
    }
}
