package com.meridal.example.twitter.domain.api;

public class UserData {

    private User data;

    public UserData() {
        // Does nothing.
    }

    public UserData(final User user) {
        this.setData(user);
    }

    public User getData() {
        return this.data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
