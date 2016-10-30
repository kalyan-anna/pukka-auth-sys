package com.pukka.model;

public class User {

	private String userId;

	private Source source;

	private Business business;

	private String loginName;

	public User(String userId, Source source, Business business, String loginName) {
		this.userId = userId;
		this.source = source;
		this.business = business;
		this.loginName = loginName;
	}

	public String getUserId() {
		return userId;
	}

	public Source getSource() {
		return source;
	}

	public Business getBusiness() {
		return business;
	}

	public String getLoginName() {
		return loginName;
	}
}
