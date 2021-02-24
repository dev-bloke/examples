package com.meridal.examples.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VehicleCertificate extends SimpleVehicle {

	private static final long serialVersionUID = 1L;
	
	private Date expiryDate;
	private String issuedBy;
	private Date startDate;
	
	@JsonIgnore
	public Vehicle getVehicle() {
		final Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNumber(this.getRegistrationNumber());
		vehicle.setMake(this.getMake());
		vehicle.setModel(this.getModel());
		vehicle.setOwner(this.getOwner());
		vehicle.setType(this.getType());
		return vehicle;
	}
	
	@JsonIgnore
	public Certificate getCertificate() {
		return new Certificate(this.startDate, this.expiryDate, this.issuedBy);
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
}
