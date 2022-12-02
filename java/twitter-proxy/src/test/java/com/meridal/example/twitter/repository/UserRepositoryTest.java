package com.meridal.example.twitter.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meridal.example.twitter.domain.api.Metrics;
import com.meridal.example.twitter.domain.api.User;
import com.meridal.example.twitter.domain.api.UserData;
import com.meridal.example.twitter.domain.api.UserListData;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryTest.class);

    private static final String LOCALHOST = "http://localhost:%s/";
    private static final String AUTHORIZATION = "Bearer XYZ123";
    private static final String ID = "1234";
    private static final Integer NUM_RESULTS = 500;
    private static final String MAX_RESULTS = "&max_results=" + NUM_RESULTS.toString();
    private static final String USERNAME = "mri";
    private static final String USER_FIELDS = "?user.fields=description,location,public_metrics";
    private static final Metrics USER_METRICS = new Metrics(150,200,3,56789);
    private static final Metrics OTHER_METRICS = new Metrics(50,75,2,54321);
    private static final User USER = new User(ID, "Martin Ingram", USERNAME, "Test user", "here", USER_METRICS);
    private static final List<User> USER_LIST = Arrays.asList(
        new User("2345", "Person 2345", "person2345", "Other user", "there", OTHER_METRICS),
        new User("3456", "Person 3456", "person3456", "Another user", "there", OTHER_METRICS),
        new User("4567", "Person 4567", "person4567", "Yet another user", "there", OTHER_METRICS)
    );
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private MockWebServer mockServer;

    private UserRepository repository;

    @BeforeEach
    public void initialize() throws Exception {
        this.mockServer = new MockWebServer();
        this.mockServer.start();
        String baseUrl = String.format(LOCALHOST, mockServer.getPort());
        this.repository = new UserRepository(baseUrl, AUTHORIZATION);;
    }

    @AfterEach
    public void tearDown() throws IOException {
        this.mockServer.shutdown();
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        this.enqueueResponse(new UserData(USER));
        final User user = this.repository.getUserByUsername(USERNAME);
        assertEquals(USER, user);
        this.checkRequest("/by/username/" + USERNAME + USER_FIELDS);
    }

    @Test
    public void testGetFollowers() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> followers = this.repository.getFollowersByUserID(ID);
        assertEquals(USER_LIST, followers);
        this.checkRequest("/" + ID + "/followers" + USER_FIELDS);
    }

    @Test
    public void testGetFollowersWithMaxResults() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> followers = this.repository.getFollowersByUserID(ID, NUM_RESULTS);
        assertEquals(USER_LIST, followers);
        this.checkRequest("/" + ID + "/followers" + USER_FIELDS + MAX_RESULTS);
    }

    @Test
    public void testGetFollowing() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> following = this.repository.getFollowingByUserID(ID);
        assertEquals(USER_LIST, following);
        this.checkRequest("/" + ID + "/following" + USER_FIELDS);
    }

    @Test
    public void testGetFollowingWithMaxResults() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> following = this.repository.getFollowingByUserID(ID, NUM_RESULTS);
        assertEquals(USER_LIST, following);
        this.checkRequest("/" + ID + "/following" + USER_FIELDS + MAX_RESULTS);
    }

    private void enqueueResponse(final Object data) throws Exception {
        final String body = MAPPER.writeValueAsString(data);
        LOG.debug("body={}", body);
        mockServer.enqueue(new MockResponse()
            .setBody(body)
            .addHeader("Content-Type", "application/json"));
    }

    private void checkRequest(final String uri) throws Exception {
        final RecordedRequest recorded = mockServer.takeRequest();
        assertEquals("GET", recorded.getMethod());
        assertEquals(AUTHORIZATION, recorded.getHeader("Authorization"));
        assertEquals(uri, recorded.getPath());
    }
}
