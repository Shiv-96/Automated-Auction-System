package com.project.beans;

public class Buyer {

	private int userId;
	private String name;
	private String username;
	private String password;
	private String email;
	
	public Buyer() {
		
	}

	public Buyer(int userId, String name, String username, String password, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Buyer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "Buyer [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}
	
	
	
}
