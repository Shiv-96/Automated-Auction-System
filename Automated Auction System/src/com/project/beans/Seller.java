package com.project.beans;

public class Seller {

	private int id;
	private String username;
	private String password;
	private String emailId;
	private String name;
	
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}
	
	public Seller(String name , String username, String password, String emailId) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
	}

	
	
	public Seller(int id, String username, String password, String emailId, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.name = name;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", username=" + username + ", password=" + password + ", emailId=" + emailId + "]";
	}
	
	
	
	
}
