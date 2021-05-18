package com.vaigay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaigay.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
