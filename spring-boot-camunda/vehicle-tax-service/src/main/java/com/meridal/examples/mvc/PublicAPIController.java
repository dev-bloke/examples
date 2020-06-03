package com.meridal.examples.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meridal.examples.domain.VehicleCertificate;
import com.meridal.examples.service.TaxService;

/**
 * Controller for public-facing API requests.
 * @author Martin Ingram
 */
@RestController
@RequestMapping("/api")
public class PublicAPIController {

	@Autowired
	private TaxService inspectionService;

	@RequestMapping(value="/tax/all", method=RequestMethod.GET)
	@ResponseBody	
	public List<VehicleCertificate> getAllVehicleCertificates() {
		return this.inspectionService.findAllVehicleCertificates();
	}

	@RequestMapping(value="/tax/{registrationNumber}", method=RequestMethod.GET)
	@ResponseBody	
	public VehicleCertificate getVehicleCertificate(@PathVariable String registrationNumber) {
		return this.inspectionService.findVehicleCertificate(registrationNumber);
	}

	@RequestMapping(value="/tax", method=RequestMethod.POST)
	@ResponseBody
	public VehicleCertificate postVehicleCertificate(@RequestBody VehicleCertificate vehicle) {
		this.inspectionService.saveVehicleCertificate(vehicle);
		return vehicle;
	}

	@RequestMapping(value="/tax/{registrationNumber}", method=RequestMethod.PUT)
	@ResponseBody
	public VehicleCertificate putVehicleCertificate(@RequestBody VehicleCertificate vehicle) {
		this.inspectionService.saveVehicleCertificate(vehicle);
		return vehicle;
	}    

	@RequestMapping(value="/tax", method=RequestMethod.DELETE)
	@ResponseBody
	public VehicleCertificate deleteVehicleCertificate(@RequestBody VehicleCertificate vehicle) {
		this.inspectionService.deleteVehicleCertificate(vehicle);
		return vehicle;
	}
}
