package com.vaigay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.UserDTO;
import com.vaigay.Entity.User;
import com.vaigay.converter.UserConverter;
import com.vaigay.security.JwtTokenProvider;
import com.vaigay.security.UserDetailImp;

@Service
public class LoginService {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private UserConverter userConverter;
    
    public String authenticate(UserDTO userDTO) {
    	User user = userConverter.convertToUser(userDTO);
    	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
    	return tokenProvider.generateToken((UserDetailImp)authentication.getPrincipal());
    }
	
}	
