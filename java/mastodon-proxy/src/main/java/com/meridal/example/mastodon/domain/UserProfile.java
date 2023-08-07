package com.meridal.example.mastodon.domain;

import java.util.List;

public class UserProfile extends User {

	private static final String NEWLINE = System.getProperty("line.separator");

	private Integer followerCount;
	private List<UserProfile> followers;
	private Integer followingCount;
	private List<UserProfile> following;
	private Integer listed;
	private Integer tweets;

	public UserProfile(final String username) {
		this.setUsername(username);
	}

	public UserProfile(final String username, final String name) {
		super(username, name);
	}

	public Integer getFollowerCount() {
		return this.followerCount;
	}

	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
	}

	public List<UserProfile> getFollowers() {
		return this.followers;
	}

	public void setFollowers(List<UserProfile> followers) {
		this.followers = followers;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public List<UserProfile> getFollowing() {
		return this.following;
	}

	public void setFollowing(List<UserProfile> following) {
		this.following = following;
	}

	public Integer getListed() {
		return this.listed;
	}

	public void setListed(final Integer listed) {
		this.listed = listed;
	}

	public Integer getTweets() {
		return this.tweets;
	}

	public void setTweets(final Integer tweets) {
		this.tweets = tweets;
	}

	public String toCSV() {
		final StringBuilder builder = new StringBuilder();
		this.appendField(builder,"ID", this.getId());
		this.appendField(builder,"User Name", this.getUsername());
		this.appendField(builder,"Followers", this.getFollowerCount());
		this.appendField(builder,"Following", this.getFollowingCount());
		this.appendField(builder,"Listed", this.getListed());
		this.appendField(builder,"Tweets", this.getTweets());
		this.appendField(builder,"Followers", this.getFollowers());
		this.appendField(builder,"Following", this.getFollowing());
		return builder.toString();
	}

	private void appendField(final StringBuilder builder, final String fieldName, final String value) {
		builder.append(fieldName)
			.append(",")
			.append(this.escapeSpecialCharacters(value))
			.append(NEWLINE);
	}

	private void appendField(final StringBuilder builder, final String fieldName, final Integer value) {
		if (value != null) {
			builder.append(fieldName)
				.append(",")
				.append(value)
				.append(NEWLINE);
		}
	}

	private void appendField(final StringBuilder builder, final String listName, final List<UserProfile> users) {
		if (users != null && !users.isEmpty()) {
			builder.append(NEWLINE)
				.append(listName)
				.append(NEWLINE)
				.append(NEWLINE)
				.append("ID, User Name, Name, Location, Followers, Following, Listed, Tweets, Description")
				.append(NEWLINE);
			for (final UserProfile user : users) {
				builder.append(user.getId()).append(",");
				builder.append(this.escapeSpecialCharacters(user.getUsername())).append(",");
				builder.append(this.countAsString(user.getFollowerCount())).append(",");
				builder.append(this.countAsString(user.getFollowingCount())).append(",");
				builder.append(this.countAsString(user.getListed())).append(",");
				builder.append(this.countAsString(user.getTweets())).append(NEWLINE);
			}
		}
	}

	private String escapeSpecialCharacters(String data) {
		String escapedData = "";
		if (data != null) {
			escapedData = data.replaceAll("\\R", " ");
			if (data.contains(",") || data.contains("\"") || data.contains("'")) {
				data = data.replace("\"", "\"\"");
				escapedData = "\"" + data + "\"";
			}
		}
		return escapedData;
	}

	private String countAsString(final Integer count) {
		return count != null ? count.toString() : "0";
	}
}
