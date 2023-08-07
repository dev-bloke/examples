package com.meridal.example.mastodon.domain.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Metrics {

	private Integer followersCount;
	private Integer followingCount;
	private Integer listedCount;
	private Integer tweetCount;

	public Metrics() {
		// Do nothing.
	}

	public Metrics(int followersCount, int followingCount, int listedCount, int tweetCount) {
		this.followersCount = followersCount;
		this.followingCount = followingCount;
		this.listedCount = listedCount;
		this.tweetCount = tweetCount;
	}

	public Integer getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getListedCount() {
		return listedCount;
	}

	public void setListedCount(Integer listedCount) {
		this.listedCount = listedCount;
	}

	public Integer getTweetCount() {
		return tweetCount;
	}

	public void setTweetCount(Integer tweetCount) {
		this.tweetCount = tweetCount;
	}
}
