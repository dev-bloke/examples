package com.meridal.examples.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.meridal.examples.domain.VehicleCertificate;

/**
 * Unit tests for {@link TaxService}.
 * @author Martin Ingram
 */
public class TaxServiceTest {
	
	private static final String REG_NO = "AB12CDE";
	private static final String OTHER_REG_NO = "FG20HJK";
	private static final String TYPE = "car";
	private static final String MAKE = "Land Rover";
	private static final String MODEL = "Freelander 2";
	private static final String OWNER = "A Tester";
	private static final String OTHER_OWNER = "Anne Othertester";
	private static final String ISSUED_BY = "Martin's Garage Services";
	
	private VehicleCertificate certificate;
	private VehicleCertificate other;
	private TaxService service;
	
	/**
	 * Initial test setup.
	 */
	@Before
	public void setup() {
		this.service = new TaxService();
		this.certificate = this.createCertificate(REG_NO, OWNER);
		this.other = this.createCertificate(OTHER_REG_NO, OTHER_OWNER);
	}
	
	/**
	 * Can we find the right certificate?
	 */
	@Test
	public void testFindVehicleCertificate() {
		this.service.put(REG_NO, this.certificate);
		this.service.put(OTHER_REG_NO, this.other);
		final VehicleCertificate cert = this.service.findVehicleCertificate(REG_NO);
		assertEquals(this.certificate, cert);
	}
	
	/**
	 * What happens when there is no certificate with the specified registration number?
	 */
	@Test
	public void testVehicleCertificateNotFound() {
		this.service.put(OTHER_REG_NO, this.other);
		final VehicleCertificate cert = this.service.findVehicleCertificate(REG_NO);
		assertNull(cert);
	}
	
	/**
	 * Can we get a list of all certificates in the cache?
	 */
	@Test
	public void testFindAllVehicleCertificates() {
		this.service.put(REG_NO, this.certificate);
		this.service.put(OTHER_REG_NO, this.other);
		final List<VehicleCertificate> certs = this.service.findAllVehicleCertificates();
		assertEquals(2, certs.size());
		assertTrue(certs.contains(this.certificate));
		assertTrue(certs.contains(this.other));
	}
	
	/**
	 * Can we use save to add a certificate to the cache?
	 */
	@Test
	public void testSaveVehicleCertificate() {
		this.service.saveVehicleCertificate(this.certificate);
		this.service.put(OTHER_REG_NO, this.other);
		final VehicleCertificate cert = this.service.findVehicleCertificate(REG_NO);
		assertEquals(this.certificate, cert);
	}
	
	/**
	 * Can we delete a certificate from the cache?
	 */
	@Test
	public void testDeleteVehicleCertificate() {
		this.service.put(REG_NO, this.certificate);
		this.service.put(OTHER_REG_NO, this.other);
		this.service.deleteVehicleCertificate(this.other);
		VehicleCertificate cert = this.service.findVehicleCertificate(REG_NO);
		assertEquals(this.certificate, cert);
		cert = this.service.findVehicleCertificate(OTHER_REG_NO);
		assertNull(cert);
	}
	
	/**
	 * Create a test certificate based on a registration number and owner.
	 * @param registrationNumber Registration Number
	 * @param owner Owner
	 * @return Test vehicle certificate
	 */
	private VehicleCertificate createCertificate(final String registrationNumber, final String owner) {
		final VehicleCertificate cert = new VehicleCertificate();
		cert.setRegistrationNumber(registrationNumber);
		cert.setType(TYPE);
		cert.setMake(MAKE);
		cert.setModel(MODEL);
		cert.setOwner(owner);
		cert.setIssuedBy(ISSUED_BY);
		final Calendar calendar = Calendar.getInstance();
		cert.setStartDate(calendar.getTime());
		calendar.add(Calendar.YEAR, 1);
		cert.setExpiryDate(calendar.getTime());
		return cert;
	}
}
