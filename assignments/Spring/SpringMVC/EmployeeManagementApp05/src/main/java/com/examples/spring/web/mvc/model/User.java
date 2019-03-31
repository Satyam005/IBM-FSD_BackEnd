package com.examples.spring.web.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	@NotNull(message = "Username cannot be empty")
	@Size(min=4, max=20, message = "Username should be between 4 to 20 characters")
	private String userName;
	
	@NotNull(message = "Password cannot be empty..!!")
	@Size(min=6, max=15, message = "Password should be between 6 to 15 characters")
	private String password;
	
	public User() {
		
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
