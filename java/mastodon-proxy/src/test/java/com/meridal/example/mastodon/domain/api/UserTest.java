package com.meridal.example.mastodon.domain.api;

import com.meridal.example.mastodon.domain.UserProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

	private static final String ID = "1234";
	private static final String DESCRIPTION = "Test user";
	private static final Integer FOLLOWERS = 150;
	private static final Integer FOLLOWING = 200;
	private static final Integer LISTED = 3;
	private static final String LOCATION = "here";
	private static final String NAME = "Martin";
	private static final Integer TWEETS = 56789;
	private static final String USERNAME = "mri";

	private static final Metrics METRICS = new Metrics(FOLLOWERS,FOLLOWING,LISTED,TWEETS);

	@Test
	public void testGetUserProfileWithMetrics() {
		final User user = new User(ID, NAME, USERNAME, DESCRIPTION, LOCATION, METRICS);
		final UserProfile profile = user.getUserProfile();
		assertEquals(ID, profile.getId());
		assertEquals(FOLLOWERS, profile.getFollowers());
		assertEquals(FOLLOWING, profile.getFollowing());
		assertEquals(LISTED, profile.getListed());
		assertEquals(TWEETS, profile.getTweets());
		assertEquals(USERNAME, profile.getUsername());
	}

	@Test
	public void testGetUserProfileWithNoMetrics() {
		final User user = new User(ID, NAME, USERNAME, DESCRIPTION, LOCATION, null);
		final UserProfile profile = user.getUserProfile();
		assertEquals(ID, profile.getId());
		assertNull(profile.getFollowers());
		assertNull(profile.getFollowing());
		assertNull(profile.getListed());
		assertNull(profile.getTweets());
		assertEquals(USERNAME, profile.getUsername());
	}
}
