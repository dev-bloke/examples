package com.meridal.examples.recordcollection.domain.discogs;

import java.util.List;

public class Format {

	private List<String> descriptions;
	private String name;
	private String qty;

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		String description = "";
		if (this.descriptions != null && !this.descriptions.isEmpty()) {
			description = this.descriptions.get(0);
		}
		return this.name + " " + description;
	}
}
