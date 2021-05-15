package com.vaigay.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaigay.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long >{
	Set<Role> findByUsers_id(long id);
	Set<Role> findByUsers_username(String name);
}
