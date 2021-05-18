package com.vaigay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaigay.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	 Optional<Cart> findByStatusAndUser_id(String status,long id);
}
