package com.meridal.examples.recordcollection.service;

import com.meridal.examples.recordcollection.repository.DiscogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscogsService {

    private final DiscogsRepository repository;

    public DiscogsService(@Autowired final DiscogsRepository repository) {
        this.repository = repository;
    }

    /*
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
    */
}
