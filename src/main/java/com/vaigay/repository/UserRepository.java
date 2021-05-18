package com.vaigay.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vaigay.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	boolean existsByUsername (String username);
	
	boolean existsByUsernameAndId (String username,long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
	int updateUserPassword(@Param("password") String password,@Param("username") String username);
	
	
	@Query("SELECT u.password FROM User u WHERE u.username = :username")
	String getUserPassword(@Param("username") String username);
	
}
