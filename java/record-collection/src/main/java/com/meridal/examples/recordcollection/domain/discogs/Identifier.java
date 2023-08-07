package com.meridal.examples.recordcollection.domain.discogs;

public class Identifier {

	private String description;
	private String type;
	private String value;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.description + " " + this.value;
	}
}
