package com.meridal.examples.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vehicles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    
    @EmbeddedId
    private VehicleModel id;
    
    @Column(name = "doors")
    private Integer doors;
    
    @Column(name = "vehicle_type")
    private String type;
    
    public Vehicle() {
	this.id = new VehicleModel();
	this.doors = 0;
	this.type = null;
    }  
    
    public Vehicle(VehicleModel id) {
	this.id = id;
	this.doors = 0;
	this.type = null;
    }
    
    public VehicleModel getId() {
        return this.id;
    }
    
    public Integer getDoors() {
        return this.doors;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setId(VehicleModel id) {
        this.id = id;
    }
    
    public void setDoors(Integer doors) {
        this.doors = doors;
    }
        
    public void setType(String type) {
        this.type = type;
    }
}
