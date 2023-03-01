package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	@Override
	public String toString() {
		return "Login [ID=" + ID + ", username=" + username + ", password=" + password + "]";
	}
	
}
