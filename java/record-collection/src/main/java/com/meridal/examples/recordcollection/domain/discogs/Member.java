package com.meridal.examples.recordcollection.domain.discogs;

import com.meridal.examples.recordcollection.domain.Entry;

public class Member extends Entry {

	private Boolean active;
	private String name;

	public Boolean getActive() {
		return active;
	}

	public boolean isActive() {
		return this.active != null && this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
