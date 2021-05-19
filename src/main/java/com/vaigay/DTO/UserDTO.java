package com.vaigay.DTO;

import java.util.Set;

public class UserDTO {
	public UserDTO(String name, String username, boolean nonBlock, Set<RoleDTO> role) {
		super();
		this.name = name;
		this.username = username;
		this.nonBlock = nonBlock;
		this.role = role;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String name;
	private String username;
	private boolean nonBlock;
	private Set<RoleDTO> role;
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
	public boolean isNonBlock() {
		return nonBlock;
	}
	public void setNonBlock(boolean nonBlock) {
		this.nonBlock = nonBlock;
	}
	public Set<RoleDTO> getRole() {
		return role;
	}
	public void setRole(Set<RoleDTO> role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
