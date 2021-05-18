package com.vaigay.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;
import com.vaigay.repository.RoleRepository;

public class UserDetailImp implements UserDetails {
	
	
	private User user;

	public UserDetailImp(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities " + user.getId());
		System.out.println(user);
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		//System.out.println(x.getTest());
		for(Role role : user.getRoles()) {
			System.out.println(role.getName());
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isNonBlock();
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public long getUserId() {
		return this.user.getId();
	}
	
	public String getName() {
		return user.getName();
	}

	@Override
	public String toString() {
		return "UserDetailImp [user=" + user + "]";
	}

}
