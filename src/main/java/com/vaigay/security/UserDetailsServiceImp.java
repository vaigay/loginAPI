package com.vaigay.security;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;
import com.vaigay.repository.RoleRepository;
import com.vaigay.repository.UserRepository;


@Component
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private RoleRepository RoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load user by username");
		User user = UserRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException(username + " not found!!!");
		Set<Role> roles = RoleRepository.findByUsers_id(user.getId());
		user.setRoles(roles);
		return new UserDetailImp(user);
		
	}
	
	//@Transactional
    public UserDetails loadUserById(Long id) {
		System.out.println("check token");
        User user = UserRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
//        Set<Role> roles = RoleRepository.findByUsers_username(user.getUsername());
//		user.setRoles(roles);
        Set<Role> roles = RoleRepository.findByUsers_id(user.getId());
		user.setRoles(roles);
        return new UserDetailImp(user);
    }
	
}
