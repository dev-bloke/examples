package com.meridal.examples.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link SimpleVehicle}.
 * @author Martin Ingram
 */
public class SimpleVehicleTest {
	
	private static final String REG_NO = "AB20CDE";
	
	private TestVehicle vehicle;
	private TestVehicle other;
	
	@Before
	public void setup() {
		this.vehicle = new TestVehicle();
		this.vehicle.setRegistrationNumber(REG_NO);
		this.other = new TestVehicle();
	}
	
	@Test
	public void testEqualsAndHashCodeWithSameRegistrationNumber() {
		this.other.setRegistrationNumber(REG_NO);
		assertEquals(this.vehicle, this.other);
		assertEquals(this.vehicle.hashCode(), this.other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWithDifferentRegistrationNumber() {
		this.other.setRegistrationNumber("FG20GHJ");
		assertNotEquals(this.vehicle, this.other);
		assertNotEquals(this.vehicle.hashCode(), this.other.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeWithNullRegistrationNumber() {
		this.other.setRegistrationNumber(null);
		assertNotEquals(this.vehicle, this.other);
		assertNotEquals(this.vehicle.hashCode(), this.other.hashCode());
	}
	
	@Test
	public void testEqualsWithNullObject() {
		assertNotEquals(this.vehicle, this.other);
		assertNotEquals(this.vehicle.hashCode(), null);
	}
}
