package com.meridal.examples.recordcollection.domain.discogs;

import com.meridal.examples.recordcollection.domain.Entry;

public class Label extends Entry {

	private String catno;
	private String name;

	public String getCatno() {
		return catno;
	}

	public void setCatno(String catno) {
		this.catno = catno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
