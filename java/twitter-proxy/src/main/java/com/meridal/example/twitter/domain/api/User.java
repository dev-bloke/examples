package com.meridal.example.twitter.domain.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User extends com.meridal.example.twitter.domain.User {

	public User() {
		super();
	}

	private Metrics publicMetrics;

	public User(final String id, final String name, final String username, final String description,
		final String location, final Metrics publicMetrics) {
		super(username, name);
		this.setId(id);
		this.setDescription(description);
		this.setPublicMetrics(publicMetrics);
		this.setLocation(location);
	}

	public Metrics getPublicMetrics() {
		return publicMetrics;
	}

	public void setPublicMetrics(Metrics publicMetrics) {
		this.publicMetrics = publicMetrics;
	}
}
