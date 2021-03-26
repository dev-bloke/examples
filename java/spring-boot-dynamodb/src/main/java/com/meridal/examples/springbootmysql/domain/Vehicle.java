package com.meridal.examples.springbootmysql.domain;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@DynamoDBTable(tableName = "vehicles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    
    @Id
    private VehicleModel id;
    private Integer doors;
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
    
    @DynamoDBAttribute
    public Integer getDoors() {
        return this.doors;
    }
    
    @DynamoDBHashKey
    public String getMake() {
	return this.getIdSafe().getMake();
    }

    @DynamoDBRangeKey
    public String getModel() {
	return this.getIdSafe().getModel();
    }

    @DynamoDBAttribute
    public String getType() {
        return this.type;
    }
    
    public void setId(VehicleModel id) {
        this.id = id;
    }
    
    public void setDoors(Integer doors) {
        this.doors = doors;
    }
    
    public void setMake(String make) {
	this.getIdSafe().setMake(make);
    }

    public void setModel(String model) {
	this.getIdSafe().setModel(model);
    }    
    
    public void setType(String type) {
        this.type = type;
    }
    
    private VehicleModel getIdSafe() {
	if (this.id == null) {
	    this.id = new VehicleModel();
	}
	return this.id;
    }
}
