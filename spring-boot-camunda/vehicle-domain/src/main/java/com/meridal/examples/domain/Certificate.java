package com.meridal.examples.domain;

import java.util.Date;

/**
 * Vehicle certificate.
 * @author Martin Ingram
 */
public class Certificate {
	
	private Date expiryDate;
	private String issuedBy;
	private Date startDate;
	
	public Certificate() {
		// Default constructor.
	}
	
	public Certificate(Date startDate, Date expiryDate, String issuedBy) {
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.issuedBy = issuedBy;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
