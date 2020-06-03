package com.meridal.examples.domain;

/**
 * Vehicle.
 * @author Martin Ingram
 */
public class Vehicle extends SimpleVehicle {
	
	private static final long serialVersionUID = 1L;

	private Certificate inspection;
	private Certificate insurance;
	private Certificate tax;
	
	public Certificate getInspection() {
		return inspection;
	}
	
	public void setInspection(Certificate inspection) {
		this.inspection = inspection;
	}
	
	public Certificate getInsurance() {
		return insurance;
	}

	public void setInsurance(Certificate insurance) {
		this.insurance = insurance;
	}

	public Certificate getTax() {
		return tax;
	}
	
	public void setTax(Certificate tax) {
		this.tax = tax;
	}
}
