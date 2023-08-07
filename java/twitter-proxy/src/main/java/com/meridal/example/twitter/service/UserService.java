package com.meridal.example.twitter.service;

import com.meridal.example.twitter.domain.UserProfile;
import com.meridal.example.twitter.domain.api.User;
import com.meridal.example.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(@Autowired final UserRepository repository) {
        this.repository = repository;
    }

    public final UserProfile getUserProfile(final String username) {
        UserProfile profile = new UserProfile(username);
        final User user = this.repository.getUserByUsername(username);
        if (user != null && user.hasId()) {
            profile = user.getUserProfile();
            final List<User> followers = this.repository.getFollowersByUserID(profile.getId(), profile.getFollowerCount());
            profile.setFollowers(this.getProfiles(followers));
            final List<User> following = this.repository.getFollowingByUserID(profile.getId(), profile.getFollowingCount());
            profile.setFollowing(this.getProfiles(following));
        }
        return profile;
    }

    public final String getUserProfileAsCSV(final String username) {
        return this.getUserProfile(username).toCSV();
    }

    private final List<UserProfile> getProfiles(final List<User> users) {
        final List<UserProfile> profiles = new ArrayList<>();
        if (users != null) {
            for (final User user : users) {
                profiles.add(user.getUserProfile());
            }
        }
        return profiles;
    }
}
