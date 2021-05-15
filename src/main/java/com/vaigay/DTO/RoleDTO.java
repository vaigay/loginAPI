package com.vaigay.DTO;

public class RoleDTO {
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
