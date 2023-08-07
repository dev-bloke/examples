package com.meridal.example.twitter.service;

import com.meridal.example.twitter.domain.UserProfile;
import com.meridal.example.twitter.domain.api.Metrics;
import com.meridal.example.twitter.domain.api.User;
import com.meridal.example.twitter.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

	private static final String ID = "1234";
	private static final String USERNAME = "mri";
	private static final String NAME = "Martin Ingram";
	private static final Integer FOLLOWER_COUNT = 3;
	private static final Integer FOLLOWING_COUNT = 3;
	private static final Metrics USER_METRICS = new Metrics(FOLLOWER_COUNT,FOLLOWING_COUNT,3,56789);
	private static final Metrics OTHER_METRICS = new Metrics(150,200,2,54321);
	private static final Metrics ZERO_METRICS = new Metrics(0,0,0,0);
	private static final User USER = new User(ID, NAME, USERNAME, "Test user", "here", USER_METRICS);
	private static final User INACTIVE_USER = new User(ID, NAME, USERNAME, "Test user", "here", ZERO_METRICS);
	private static final List<User> USER_LIST = Arrays.asList(
		new User("2345", "Person 2345", "person2345", "Other user", "there", OTHER_METRICS),
		new User("3456", "Person 3456", "person3456", "Another user", "there", OTHER_METRICS),
		new User("4567", "Person 4567", "person4567", "Yet another user", "there", OTHER_METRICS)
	);

	private UserRepository repository;
	private UserService service;

	@BeforeEach
	public void setup() {
		this.repository = mock(UserRepository.class);
		this.service = new UserService(this.repository);
	}

	@Test
	public void testGetFullUserProfile() {
		when(this.repository.getUserByUsername(USERNAME)).thenReturn(USER);
		when(this.repository.getFollowersByUserID(ID, FOLLOWER_COUNT)).thenReturn(USER_LIST);
		when(this.repository.getFollowingByUserID(ID, FOLLOWING_COUNT)).thenReturn(USER_LIST);
		final UserProfile profile = this.service.getUserProfile(USERNAME);
		assertNotNull(profile);
		assertEquals(ID, profile.getId());
		assertEquals(NAME, profile.getName());
		assertEquals(FOLLOWER_COUNT, profile.getFollowerCount());
		assertNotNull(profile.getFollowers());
		assertEquals(FOLLOWER_COUNT, profile.getFollowers().size());
		assertEquals(FOLLOWING_COUNT, profile.getFollowingCount());
		assertNotNull(profile.getFollowing());
		assertEquals(FOLLOWER_COUNT, profile.getFollowing().size());
	}

	@Test
	public void testGetInvalidUserProfile() {
		when(this.repository.getUserByUsername(USERNAME)).thenReturn(null);
		when(this.repository.getFollowersByUserID(ID, FOLLOWER_COUNT)).thenReturn(USER_LIST);
		when(this.repository.getFollowingByUserID(ID, FOLLOWING_COUNT)).thenReturn(USER_LIST);
		final UserProfile profile = this.service.getUserProfile(USERNAME);
		assertNotNull(profile);
		assertFalse(profile.hasId());
		assertNull(profile.getName());
		assertNull(profile.getFollowerCount());
		assertNull(profile.getFollowers());
		assertNull(profile.getFollowingCount());
		assertNull(profile.getFollowing());
	}

	@Test
	public void testGetInactiveUserProfile() {
		when(this.repository.getUserByUsername(USERNAME)).thenReturn(INACTIVE_USER);
		when(this.repository.getFollowersByUserID(ID, FOLLOWER_COUNT)).thenReturn(USER_LIST);
		when(this.repository.getFollowingByUserID(ID, FOLLOWING_COUNT)).thenReturn(USER_LIST);
		final UserProfile profile = this.service.getUserProfile(USERNAME);
		assertNotNull(profile);
		assertEquals(NAME, profile.getName());
		assertEquals(0, profile.getFollowerCount());
		assertNotNull(profile.getFollowers());
		assertTrue(profile.getFollowers().isEmpty());
		assertEquals(0, profile.getFollowingCount());
		assertNotNull(profile.getFollowing());
		assertTrue(profile.getFollowing().isEmpty());
	}
}
