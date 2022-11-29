package com.meridal.example.twitter.domain.api;

import com.meridal.example.twitter.domain.User;

import java.util.List;

public class UserListData {

    private List<User> data;

    public UserListData() {
        // Does nothing.
    }

    public UserListData(final List<User> users) {
        this.setData(users);
    }

    public List<User> getData() {
        return this.data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
