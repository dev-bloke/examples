package com.meridal.examples.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VehicleModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "make", nullable = false)
    private String make;
    
    @Column(name = "model", nullable = false)
    private String model;
    
    public VehicleModel() {
    }
    
    public VehicleModel(String make, String model) {
	this.make = make;
	this.model = model;
    }
    
    public String getMake() {
        return this.make;
    }

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
