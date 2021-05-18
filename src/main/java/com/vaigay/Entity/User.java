package com.vaigay.Entity;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
	public User(long id, String name, String username, String password, boolean nonBlock) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.nonBlock = nonBlock;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String username;
	private String password;
	private boolean nonBlock;
	
	@ManyToMany
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =  @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private List<Cart> cart;

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

	public boolean isNonBlock() {
		return nonBlock;
	}
	

	public void setNonBlock(boolean nonBlock) {
		this.nonBlock = nonBlock;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", nonBlock="
				+ nonBlock + "]";
	}

	
	
	
}
