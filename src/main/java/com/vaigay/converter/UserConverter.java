package com.vaigay.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaigay.DTO.RoleDTO;
import com.vaigay.DTO.UserDTO;
import com.vaigay.Entity.Role;
import com.vaigay.Entity.User;


@Component
public class UserConverter {

	@Autowired
	private RoleConverter roleConverter;
	
	public User convertToUser(UserDTO userDTO) {
		User u = new User();
		u.setUsername(userDTO.getUsername());
		u.setId(userDTO.getId());
		u.setNonBlock(userDTO.isNonBlock());
		u.setPhoneNumber(userDTO.getPhoneNumber());
		if(userDTO.getRole() != null) {
			Set<Role> roles = new HashSet<Role>();
			for(RoleDTO roleDTO : userDTO.getRole()) {
				roles.add(roleConverter.toRole(roleDTO));
			}
			u.setRoles(roles);
		}
		u.setName(userDTO.getName());
		return u;
	}
	
	public UserDTO convertToUserDTO(User user) {
		UserDTO u = new UserDTO();
		u.setUsername(user.getUsername());
		u.setId(user.getId());
		u.setNonBlock(user.isNonBlock());
		u.setPhoneNumber(user.getPhoneNumber());
		if(user.getRoles() != null) {
			Set<RoleDTO> roles = new HashSet<RoleDTO>();
			for(Role role : user.getRoles()) {
				roles.add(roleConverter.toRoleDTO(role));
			}
			u.setRole(roles);
		}
		u.setName(user.getName());
		return u;
	}
}
