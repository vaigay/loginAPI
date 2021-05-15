package com.vaigay.converter;

import org.springframework.stereotype.Component;

import com.vaigay.DTO.RoleDTO;
import com.vaigay.Entity.Role;

@Component
public class RoleConverter {
	
	public Role toRole(RoleDTO roleDTO) {
		Role role = new Role();
		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		return role;
	}
	
	public RoleDTO toRoleDTO(Role role) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(role.getId());
		roleDTO.setName(role.getName());
		return roleDTO;
	}
	
}
