package com.meridal.examples.domain;

import java.io.Serializable;
import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

@DynamoDBDocument
public class VehicleModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String make;
    private String model;
    
    public VehicleModel() {
    }
    
    public VehicleModel(String make, String model) {
	this.make = make;
	this.model = model;
    }
    
    @DynamoDBHashKey
    public String getMake() {
        return this.make;
    }

    @DynamoDBRangeKey
    public String getModel() {
        return this.model;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof VehicleModel) {
            final VehicleModel other = (VehicleModel) o;
            result = Objects.equals(this.make, other.make) && Objects.equals(this.model, other.model);         
        }
        return result;
    }
    
    @Override
    public int hashCode() {
        String makeModel = this.make + this.model;
        return makeModel.hashCode();
    }
}
