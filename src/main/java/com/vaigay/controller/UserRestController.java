package com.vaigay.controller;

import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaigay.DTO.ChangePassword;
import com.vaigay.DTO.LoginUser;
import com.vaigay.DTO.RegisterUser;
import com.vaigay.DTO.UserDTO;
import com.vaigay.service.UserChecking;
import com.vaigay.service.UserService;
@CrossOrigin
@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserChecking userChecking;
	
	@GetMapping("/home")//không cần login
	public String getHome() {
		return "everyone can visit";
	}
	
	
	@PostMapping("/login")//không cần login
	public ResponseEntity<String> login(@RequestBody LoginUser user) {
		return new ResponseEntity<String>(userService.authenticate(user),HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUserPassword(@RequestBody ChangePassword user) {
		String username = userChecking.getUserName();
		System.out.println(user);
		if(!userService.checkUserPassWord(user,username)) {
			return new ResponseEntity<String>("OldPassword is incorrect",HttpStatus.FORBIDDEN);
		}
		if(userService.updateUserPassword(user,username) != 0)
			return new ResponseEntity<String>("Update password successfully",HttpStatus.OK);
		return new ResponseEntity<String>("Can not update your password",HttpStatus.CONFLICT);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> adminGetOneUser(@PathVariable(name = "id") long id) {
		UserDTO userDTO =userService.getOneUser(id);
		if(!userChecking.isAdmin()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		if(userDTO == null)
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
	}
	
	@GetMapping("/userInfo")//lấy thông tin của chính user
	public ResponseEntity<UserDTO> getUserInfo(){
		long id = userChecking.getIdUser();
		UserDTO userDTO =userService.getOneUser(id);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser(){
		List<UserDTO> userDTOs = userService.getAllUser();
		return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
		
	}
	
	@PostMapping("/register")//không cần login
	public ResponseEntity<?> register(@RequestBody RegisterUser user){
		System.out.println(user);
		if(user.getPhoneNumber() == null || user.getPhoneNumber().equals("") || user.getName() == null || user.getName().equals("") || user.getPassword() == null || user.getPassword().equals("") || user.getUsername() == null || user.getUsername().equals("")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(userService.checkUsernameExists(user.getUsername()))
			return new ResponseEntity<String>("Username has been taken",HttpStatus.BAD_REQUEST);
		userService.saveUserResigter(user);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
