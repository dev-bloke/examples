package com.meridal.example.twitter.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meridal.example.twitter.domain.User;
import com.meridal.example.twitter.domain.api.UserData;
import com.meridal.example.twitter.domain.api.UserListData;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private static final String LOCALHOST = "http://localhost:%s/";
    private static final String AUTHORIZATION = "Bearer XYZ123";
    private static final Integer MAX_RESULTS = 500;
    private static final String ID = "1234";
    private static final String USERNAME = "mri";
    private static final User USER = new User(ID, "Martin Ingram", USERNAME);
    private static final List<User> USER_LIST = Arrays.asList(
        new User("2345", "Person 2345", "person2345"),
        new User("3456", "Person 3456", "person3456"),
        new User("4567", "Person 4567", "person4567")
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
        this.checkRequest("/by/username/" + USERNAME);
    }

    @Test
    public void testGetFollowers() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> followers = this.repository.getFollowersByUserID(ID);
        assertEquals(USER_LIST, followers);
        this.checkRequest("/" + ID + "/followers");
    }

    @Test
    public void testGetFollowersWithMaxResults() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> followers = this.repository.getFollowersByUserID(ID, MAX_RESULTS);
        assertEquals(USER_LIST, followers);
        this.checkRequest("/" + ID + "/followers?max_results=" + MAX_RESULTS.toString());
    }

    @Test
    public void testGetFollowing() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> following = this.repository.getFollowingByUserID(ID);
        assertEquals(USER_LIST, following);
        this.checkRequest("/" + ID + "/following");
    }

    @Test
    public void testGetFollowingWithMaxResults() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> following = this.repository.getFollowingByUserID(ID, 500);
        assertEquals(USER_LIST, following);
        this.checkRequest("/" + ID + "/following?max_results=" + MAX_RESULTS.toString());
    }

    private void enqueueResponse(final Object data) throws Exception {
        mockServer.enqueue(new MockResponse()
            .setBody(MAPPER.writeValueAsString(data))
            .addHeader("Content-Type", "application/json"));
    }

    private void checkRequest(final String uri) throws Exception {
        final RecordedRequest recorded = mockServer.takeRequest();
        assertEquals("GET", recorded.getMethod());
        assertEquals(uri, recorded.getPath());
    }
}
