package com.google.demoForIdea.model;

import java.io.Serializable;

public class User<T> implements Serializable {
	private static final long serialVersionUID = -1672970955045193907L;
	String username;
	Long userid;


	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", userid=" + userid +
				'}';
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
