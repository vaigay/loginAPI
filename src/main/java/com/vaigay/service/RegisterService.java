package com.vaigay.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.UserDTO;
import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;
import com.vaigay.converter.UserConverter;
import com.vaigay.repository.UserRepository;

@Service
public class RegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserConverter userConverter;
	
	public boolean checkUsernameExists(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public void saveUserResigter(UserDTO userDTO) {
		User user = userConverter.convertToUser(userDTO);
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		Set<Role> roles = new HashSet<Role>();
		Role r = new Role();
		r.setId(2);
		roles.add(r);
		user.setNonBlock(true);
		user.setRoles(roles);
		userRepository.save(user);
	}
		
}
