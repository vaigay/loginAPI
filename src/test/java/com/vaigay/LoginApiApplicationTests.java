package com.vaigay;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;
import com.vaigay.repository.RoleRepository;
import com.vaigay.repository.UserRepository;

@SpringBootTest
class LoginApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private RoleRepository RoleRepository;
	
	@Test
	public void inserUSer() {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String password = "admin";
		String endcodep = b.encode(password);
		
		User x = new User();
		x.setName("vaigay");
		x.setNonBlock(true);
		x.setUsername("user");
		x.setPassword(b.encode("user"));
		
		User y = new User();
		y.setName("admin");
		y.setNonBlock(true);
		y.setUsername("admin");
		y.setPassword(b.encode("admin"));
		
		Role ru = new Role();
		ru.setName("user");;
		
		Role ra = new Role();
		ra.setName("admin");
		
		RoleRepository.save(ru);
		RoleRepository.save(ra);
		
		Set<Role> k = new HashSet<Role>();
		k.add(ru);
		
		Set<Role> kk = new HashSet<Role>();
		kk.add(ra);
		
		x.setRoles(k);
		
		y.setRoles(kk);
		
		
		
		UserRepository.save(x);
		UserRepository.save(y);
		
	}

}
