package com.meridal.examples.recordcollection.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meridal.examples.recordcollection.domain.SearchResult;
import com.meridal.examples.recordcollection.domain.discogs.*;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscogsRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(DiscogsRepositoryTest.class);

    private static final String COUNTRY = "UK";
    private static final String FORMAT = "Vinyl";
    private static final String MOVING_PICTURES = "Moving Pictures";
    private static final String MOVING_PICTURES_MASTER = "7532";
    private static final String MOVING_PICTURES_RELEASE = "369391";
    private static final String RUSH = "Rush";
    private static final String RUSH_ID = "61800";
    private static final String SEARCH_TYPE = "artist";

    private static final String LOCALHOST = "http://localhost:%s/";
    private static final String AUTHORIZATION = "Bearer XYZ123";
    private static final String ID = "1234";
    private static final Integer NUM_RESULTS = 500;
    private static final String MAX_RESULTS = "&max_results=" + NUM_RESULTS.toString();
    private static final String USERNAME = "mri";
    private static final String USER_FIELDS = "?user.fields=description,location,public_metrics";
    /*
    private static final Metrics USER_METRICS = new Metrics(150,200,3,56789);
    private static final Metrics OTHER_METRICS = new Metrics(50,75,2,54321);
    private static final User USER = new User(ID, "Martin Ingram", USERNAME, "Test user", "here", USER_METRICS);
    private static final List<User> USER_LIST = Arrays.asList(
        new User("2345", "Person 2345", "person2345", "Other user", "there", OTHER_METRICS),
        new User("3456", "Person 3456", "person3456", "Another user", "there", OTHER_METRICS),
        new User("4567", "Person 4567", "person4567", "Yet another user", "there", OTHER_METRICS)
    );
    */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private MockWebServer mockServer;

    private DiscogsRepository repository;

    @BeforeEach
    public void initialize() throws Exception {
        /*
        this.mockServer = new MockWebServer();
        this.mockServer.start();
        String baseUrl = String.format(LOCALHOST, mockServer.getPort());
        */
        this.repository = new DiscogsRepository("https://api.discogs.com",
            "Discogs key=TYIebePzQdNvOvYOhyjt, secret=qJsSDgnRjnaeMOwpApYmSAtRcUYwusmm",
            100,
            "Discogs token=HaMlMPZNyJSjbMLrFUTvILxgJlfHMctJgQKsEZVV");;
    }

    @Test
    public void testGetArtistByID() {
        final Artist artist = this.repository.getArtistByID(RUSH_ID);
        assertNotNull(artist);
        assertEquals("Rush", artist.getName());
        assertEquals(4, artist.getMembers().size());
    }

    @Test
    public void testGetMasterUrlWithNoParameters() {
        final String url = this.repository.getMasterUrl(MOVING_PICTURES_MASTER, null, null);
        assertEquals("/masters/" + MOVING_PICTURES_MASTER + "/versions", url);
    }

    @Test
    public void testGetMasterUrlWithCountry() {
        final String url = this.repository.getMasterUrl(MOVING_PICTURES_MASTER, COUNTRY, null);
        assertEquals("/masters/" + MOVING_PICTURES_MASTER + "/versions?country=" + COUNTRY, url);
    }

    @Test
    public void testGetMasterUrlWithFormat() {
        final String url = this.repository.getMasterUrl(MOVING_PICTURES_MASTER, null, FORMAT);
        assertEquals("/masters/" + MOVING_PICTURES_MASTER + "/versions?format=" + FORMAT, url);
    }

    @Test
    public void testGetMasterUrlWithFormatAndCountry() {
        final String url = this.repository.getMasterUrl(MOVING_PICTURES_MASTER, COUNTRY, FORMAT);
        assertEquals("/masters/" + MOVING_PICTURES_MASTER + "/versions?country=" + COUNTRY + "&format=" + FORMAT, url);
    }

    @Test
    public void testGetMasterByID() {
        final Master master = this.repository.getMasterByID(MOVING_PICTURES_MASTER);
        assertNotNull(master);
        LOG.debug("Master: {}", master);
    }

    @Test
    public void testGetMasterByIDWithFilter() {
        final Master master = this.repository.getMasterByID(MOVING_PICTURES_MASTER, COUNTRY, FORMAT);
        assertNotNull(master);
        LOG.debug("Master: {}", master);
    }

    @Test
    public void testGetReleaseByID() {
        final Release release = this.repository.getReleaseByID(MOVING_PICTURES_RELEASE);
        assertNotNull(release);
        LOG.debug("Release: {}", release);
    }

    @Test
    public void testGetPriceSuggestionByID() {
        final PriceSuggestion suggestion = this.repository.getPriceSuggestionByID(MOVING_PICTURES_RELEASE);
        assertNotNull(suggestion);
        LOG.debug("Price Suggestion: {}", suggestion);
    }

    @Test
    public void testGetSearchUrl() {
        final String url = this.repository.getSearchUrl(RUSH, SEARCH_TYPE);
        assertEquals("/database/search?q=" + RUSH + "&type=" + SEARCH_TYPE + "&per_page=100", url);
    }

    @Test
    public void testSearchForArtist() {
        final SearchResults results = this.repository.searchForArtist(RUSH);
        assertNotNull(results);
        final SearchResult result = new SearchResult(Integer.valueOf(RUSH_ID), RUSH);
        assertTrue(results.getResults().contains(result));
        LOG.debug("Artist Search: {}", results);
    }

    @Test
    public void testSearchForMaster() {
        final SearchResults results = this.repository.searchForMaster(MOVING_PICTURES);
        assertNotNull(results);
        final SearchResult result = new SearchResult(Integer.valueOf(MOVING_PICTURES_MASTER), MOVING_PICTURES);
        LOG.debug("Master Search: {}", results);
        assertTrue(results.getResults().contains(result));
    }

    @AfterEach
    public void tearDown() throws IOException {
        /*
        this.mockServer.shutdown();
         */
    }

    /*
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
    public void testGetFollowersWithNullMaxResults() throws Exception {
        this.enqueueResponse(new UserListData(USER_LIST));
        final List<User> followers = this.repository.getFollowersByUserID(ID, null);
        assertEquals(USER_LIST, followers);
        this.checkRequest("/" + ID + "/followers" + USER_FIELDS);
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
        final List<User> following = this.repository.getFollowingByUserID(ID, null);
        assertEquals(USER_LIST, following);
        this.checkRequest("/" + ID + "/following" + USER_FIELDS);
    }

    @Test
    public void testGetFollowingWithNullMaxResults() throws Exception {
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
     */
}
