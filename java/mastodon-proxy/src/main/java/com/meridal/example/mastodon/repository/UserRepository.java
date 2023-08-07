package com.meridal.example.mastodon.repository;

import com.meridal.example.mastodon.domain.api.User;
import com.meridal.example.mastodon.domain.api.UserData;
import com.meridal.example.mastodon.domain.api.UserListData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import java.util.List;

@Repository
public class UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);
    private static final String GET_USER = "by/username/";
    private static final String GET_FOLLOWERS = "/followers";
    private static final String GET_FOLLOWING = "/following";
    private static final String MAX_RESULTS = "&max_results=";
    private static final String USER_FIELDS = "?user.fields=description,location,public_metrics";

    private final WebClient client;
    private final String authorization;

    public UserRepository(
        @Value("${api2.baseUrl}") final String baseUrl,
        @Value("${api2.authorization}") final String authorization) {
        LOG.debug("baseUrl={}", baseUrl);
        LOG.debug("authorization={}", authorization);
        this.client = this.createWebClient(baseUrl);
        this.authorization = authorization;
    }

    public User getUserByUsername(final String username) {
        final ResponseSpec responseSpec = this.getResponseSpec(GET_USER + username + USER_FIELDS);
        final UserData data = responseSpec.bodyToMono(UserData.class).block();
        return data.getData();
    }

    public List<User> getFollowersByUserID(final String userID) {
        return this.getFollowersByUserID(userID, 0);
    }

    public List<User> getFollowersByUserID(final String userID, final Integer maxResults) {
        final String uri = this.getUriWithMaxResults(GET_FOLLOWERS, userID, maxResults);
        final ResponseSpec responseSpec = this.getResponseSpec(uri);
        final UserListData followers = responseSpec.bodyToMono(UserListData.class).block();
        return followers.getData();
    }

    public List<User> getFollowingByUserID(final String userID) {
        return this.getFollowingByUserID(userID, 0);
    }

    public List<User> getFollowingByUserID(final String userID, final Integer maxResults) {
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

    private String getUriWithMaxResults(final String uri, final String userID, Integer maxResults) {
        final StringBuilder builder = new StringBuilder(userID)
            .append(uri)
            .append(USER_FIELDS);
        if (maxResults != null && maxResults > 0) {
            builder.append(MAX_RESULTS).append(maxResults);
        }
        return builder.toString();
    }
}
