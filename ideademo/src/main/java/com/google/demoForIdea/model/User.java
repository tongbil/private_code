package com.google.demoForIdea.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -1672970955045193907L;
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
