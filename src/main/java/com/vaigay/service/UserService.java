package com.vaigay.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.ChangePassword;
import com.vaigay.DTO.LoginUser;
import com.vaigay.DTO.RegisterUser;
import com.vaigay.DTO.UserDTO;
import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;
import com.vaigay.converter.UserConverter;
import com.vaigay.repository.UserRepository;
import com.vaigay.security.JwtTokenProvider;
import com.vaigay.security.UserDetailImp;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private UserConverter userConverter;
    
    public String authenticate(LoginUser user) {
    	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	return tokenProvider.generateToken((UserDetailImp)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
	
	public boolean checkUsernameExists(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public void saveUserResigter(RegisterUser userRegister) {
		User user = new User();
		user.setName(userRegister.getName());
		String password = userRegister.getPassword();
		user.setUsername(userRegister.getUsername());
		user.setPassword(passwordEncoder.encode(password));
		user.setPhoneNumber(userRegister.getPhoneNumber());
		Set<Role> roles = new HashSet<Role>();
		Role r = new Role();
		r.setId(2);
		roles.add(r);
		user.setNonBlock(true);
		user.setRoles(roles);
		userRepository.save(user);
		System.out.println(user);
	}
	
	public boolean checkUserExists(String username, long id) {
		return userRepository.existsByUsernameAndId(username, id);
	}
	
	public int updateUserPassword(ChangePassword user,String username) {
		String encode = passwordEncoder.encode(user.getNewPassword());
		return userRepository.updateUserPassword(encode,username);
	}
	
		
	public UserDTO getOneUser(long id) {
		User u = userRepository.findById(id).orElse(null);
		if(u == null)
			return null;
		return userConverter.convertToUserDTO(u);
	}
	
	public List<UserDTO> getAllUser(){
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users){
			usersDTO.add(userConverter.convertToUserDTO(user));
		}
		return usersDTO;
	}
	
	
	public boolean checkUserPassWord(ChangePassword user,String username) {
		String userPassword = userRepository.getUserPassword(username);
		return passwordEncoder.matches(user.getOldPassword(), userPassword);
	}
	
	public UserDTO getUserByIdBill(long id) {
		return userConverter.convertToUserDTO(userRepository.findByCart_Bill_Id(id).orElse(null));
	}

}
