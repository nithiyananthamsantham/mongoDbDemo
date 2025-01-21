package com.chirohi.mongodemo.postgres.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
	@NotNull(message = "Username cannot be null.")
	@NotBlank(message = "Username cannot be blank.")
	@Email
	private String username;
	@NotBlank(message = "Password cannot be blank.")
	private String password;
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
