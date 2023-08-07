package com.meridal.examples.recordcollection.domain.discogs;

import com.meridal.examples.recordcollection.domain.Entry;

import java.util.List;

public class Artist extends Entry {

	private List<Member> members;
	private String name;
	private String profile;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
