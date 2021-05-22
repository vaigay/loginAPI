package com.vaigay.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vaigay.security.UserDetailImp;

@Component("userChecking")
public class UserChecking {
	
//	public boolean isAdmin() {
//		
//		UserDetailImp p = getUserPrincipal();
//		for(GrantedAuthority au : p.getAuthorities()) {
//			System.out.println("Author: " + au.getAuthority());
//		}
//		GrantedAuthority x = new SimpleGrantedAuthority("ROLE_ADMIN");
//		if(p.getAuthorities().contains(GrantedAuthority("")))
//			return true;
//		return false;
//	}
	
	public boolean isUserInfoOfUser(long idUser) {
		UserDetailImp p = getUserPrincipal();
		if(p.getUserId() == idUser || p.getAuthorities().contains("ADMIN"))
			return true;
		return false;
	}
	
	public UserDetailImp getUserPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailImp p = (UserDetailImp) authentication.getPrincipal();
		return p;
	}
	
	public String getUserName() {
		return getUserPrincipal().getUsername();
	}
	
	public long getIdUser() {
		return getUserPrincipal().getUserId();
	}
}
