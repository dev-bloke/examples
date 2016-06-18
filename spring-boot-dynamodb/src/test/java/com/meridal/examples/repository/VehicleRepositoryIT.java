package com.meridal.examples.repository;

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
public class VehicleRepositoryIT extends TestFramework {
        
    @Autowired
    private VehicleRepository repository;
    
    @Test
    public void testCRUD() {
	Vehicle vehicle = this.createVehicle();
	this.repository.save(vehicle);
	VehicleModel id = vehicle.getId();
	assertNotNull(id);
	Vehicle other = this.repository.findOne(id);
	this.checkVehicle(other, WRONG_DOORS);
	vehicle.setDoors(DOORS);
	this.repository.save(vehicle);
	other = this.repository.findOne(id);
	this.checkVehicle(other, DOORS);
	this.repository.delete(vehicle);
	other = this.repository.findOne(id);
	assertNull(other);
    }
}
