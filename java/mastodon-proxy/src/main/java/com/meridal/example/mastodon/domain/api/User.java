package com.meridal.example.mastodon.domain.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.meridal.example.mastodon.domain.UserProfile;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User extends com.meridal.example.mastodon.domain.User {

	public User() {
		super();
	}

	private Metrics publicMetrics;

	public User(final String id, final String name, final String username, final String description,
		final String location, final Metrics publicMetrics) {
		super(username, name);
		this.setId(id);
		this.setPublicMetrics(publicMetrics);
	}

	public Metrics getPublicMetrics() {
		return publicMetrics;
	}

	public void setPublicMetrics(Metrics publicMetrics) {
		this.publicMetrics = publicMetrics;
	}

	public UserProfile getUserProfile() {
		final UserProfile profile = new UserProfile(this.getUsername(), null);
		profile.setId(this.getId());
		if (this.publicMetrics != null) {
			profile.setFollowerCount(this.publicMetrics.getFollowersCount());
			profile.setFollowingCount(this.publicMetrics.getFollowingCount());
			profile.setListed(this.publicMetrics.getListedCount());
			profile.setTweets(this.publicMetrics.getTweetCount());
		}
		return profile;
	}
}
