package com.meridal.examples.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meridal.examples.domain.VehicleCertificate;

/**
 * In memory vehicle inspection certificate cache.
 * @author Martin Ingram
 */
@Service
public class TaxService extends LinkedHashMap<String, VehicleCertificate>{

	private static final long serialVersionUID = 1L;

	/**
	 * Get all the vehicles in the cache.
	 * @return A list of all vehicles in the cache
	 */
	public List<VehicleCertificate> findAllVehicleCertificates() {
		return new ArrayList<>(this.values());
	}
	
	/**
	 * Delete the vehicle details from the cache.
	 * @param vehicle VehicleCertificate
	 */
	public void deleteVehicleCertificate(final VehicleCertificate vehicle) {
		if (vehicle != null) {
			final String key = vehicle.getRegistrationNumber();
			if (key != null) {
				this.remove(key);
			}
		}
	}
	
	/**
	 * Find a vehicle by registration number.
	 * @param registrationNumber Registration number
	 * @return The vehicle details, or null if not found
	 */
	public VehicleCertificate findVehicleCertificate(final String registrationNumber) {
		return this.get(registrationNumber);
	}
	
	/**
	 * Save vehicle details to the cache.
	 * @param vehicle VehicleCertificate
	 */
	public void saveVehicleCertificate(final VehicleCertificate vehicle) {
		if (vehicle != null) {
			final String key = vehicle.getRegistrationNumber();
			if (key != null) {
				this.put(key, vehicle);
			}
		}
	}
}
