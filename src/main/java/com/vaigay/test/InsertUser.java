package com.vaigay.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vaigay.Entity.User;
import com.vaigay.repository.UserRepository;


public class InsertUser {
	
//	@Autowired
//	private UserRepository UserRepository;
//	
//	@Test
//	public void inserUSer() {
//		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//		String password = "abcxx";
//		String endcodep = b.encode(password);
//		
//		User u = new User();
//		u.setName("Hai Pham");
//		u.setUsername("test");
//		u.setPassword(endcodep);
//		u.setNonBlock(true);
//		
//		System.out.println(endcodep);
//		UserRepository.save(u);
//	}
}
