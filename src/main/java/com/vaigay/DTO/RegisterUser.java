package com.vaigay.DTO;

public class RegisterUser {
	
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String username;
	private String password;
	private String phoneNumber;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "RegisterUser [name=" + name + ", username=" + username + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
