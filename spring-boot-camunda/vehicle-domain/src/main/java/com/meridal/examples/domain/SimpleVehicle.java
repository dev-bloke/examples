package com.meridal.examples.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class SimpleVehicle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String registrationNumber;
	
	private String make;
	private String model;
	private String owner;
	private String type;
	
    /**
     * {@inheritDoc}
     */
	@Override
    public boolean equals(Object o) {
    	boolean result = false;
    	if (o != null && this instanceof SimpleVehicle) {
    		SimpleVehicle other = (SimpleVehicle) o;
    		result = Objects.equals(this.registrationNumber, other.registrationNumber);
    	}
    	return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
    	return this.registrationNumber != null ? this.registrationNumber.hashCode() : 0;
    }
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
