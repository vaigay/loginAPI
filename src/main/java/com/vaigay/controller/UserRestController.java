package com.vaigay.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaigay.DTO.LoginUser;
import com.vaigay.DTO.RegisterUser;
import com.vaigay.DTO.UserDTO;
import com.vaigay.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")//không cần login
	public String getHome() {
		return "everyone can visit";
	}
	
	
	@PostMapping("/login")//không cần login
	public ResponseEntity<String> login(@RequestBody LoginUser user) {
		return new ResponseEntity<String>(userService.authenticate(user),HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")//user gửi request phải cùng id với user.id(user request body của json)
	public ResponseEntity<?> updateUserPassword(@PathVariable(name = "id") long id, @RequestBody RegisterUser user) {
		if(!userService.isRightUser(id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		if(!userService.checkUserExists(user.getUsername(),id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		if(userService.updateUserPassword(user, id) != 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> adminPage(@PathVariable(name = "id") long id) {
		UserDTO userDTO =userService.getOneUser(id);
		if(userDTO == null)
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
	}
	
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> getAllUser(){
		List<UserDTO> userDTOs = userService.getAllUser();
		if(userDTOs.size() == 0)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
		
	}
	
	@PostMapping("/register")//không cần login
	public ResponseEntity<?> register(@RequestBody RegisterUser user){
		if(userService.checkUsernameExists(user.getUsername()) || user.getName() == null || user.getName().equals("") || user.getPassword() == null || user.getPassword().equals("") || user.getUsername() == null || user.getUsername().equals("")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		userService.saveUserResigter(user);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
