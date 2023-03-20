package com.teamBus.web.entity;

import java.util.Date;

public class Member {
	private int id;
	private String username;
	private String email;
	private Date regDate;

	public Member() {
		
	}
	
	public Member(int id, String username, String email, Date regDate) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", email=" + email + ", regDate=" + regDate + "]";
	}

}

