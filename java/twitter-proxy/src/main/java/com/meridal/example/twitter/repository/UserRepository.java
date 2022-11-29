package com.meridal.example.twitter.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meridal.example.twitter.domain.User;
import com.meridal.example.twitter.domain.api.UserData;
import com.meridal.example.twitter.domain.api.UserListData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@ConfigurationProperties(prefix = "api2")
public class UserRepository {

    private static final String GET_USER = "by/username/";
    private static final String GET_FOLLOWERS = "/followers";
    private static final String GET_FOLLOWING = "/following";
    private static final String MAX_RESULTS = "?max_results=";

    private final WebClient client;
    private final String authorization;

    public UserRepository(
        @Value("baseUrl") final String baseUrl,
        @Value("authorization") final String authorization) {
        this.client = this.createWebClient(baseUrl);
        this.authorization = authorization;
    }

    public User getUserByUsername(final String username) {
        final ResponseSpec responseSpec = this.getResponseSpec(GET_USER + username);
        final UserData data = responseSpec.bodyToMono(UserData.class).block();
        return data.getData();
    }

    public List<User> getFollowersByUserID(final String userID) {
        return this.getFollowersByUserID(userID, 0);
    }

    public List<User> getFollowersByUserID(final String userID, final int maxResults) {
        final String uri = this.getUriWithMaxResults(GET_FOLLOWERS, userID, maxResults);
        final ResponseSpec responseSpec = this.getResponseSpec(uri);
        final UserListData followers = responseSpec.bodyToMono(UserListData.class).block();
        return followers.getData();
    }

    public List<User> getFollowingByUserID(final String userID) {
        return this.getFollowingByUserID(userID, 0);
    }

    public List<User> getFollowingByUserID(final String userID, final int maxResults) {
        final String uri = this.getUriWithMaxResults(GET_FOLLOWING, userID, maxResults);
        final ResponseSpec responseSpec = this.getResponseSpec(uri);
        final UserListData followers = responseSpec.bodyToMono(UserListData.class).block();
        return followers.getData();
    }

    private WebClient createWebClient(final String baseUrl) {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .build();
    }

    private ResponseSpec getResponseSpec(final String uri) {
        return this.client.get()
            .uri(uri)
            .header("Authorization", this.authorization)
            .retrieve();
    }

    private String getUriWithMaxResults(final String uri, final String userID, int maxResults) {
        final StringBuilder builder = new StringBuilder(userID).append(uri);
        if (maxResults > 0) {
            builder.append(MAX_RESULTS).append(maxResults);
        }
        return builder.toString();
    }
}
