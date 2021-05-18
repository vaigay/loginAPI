package com.vaigay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vaigay.Entity.ProductInCart;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
	
	@Query("SELECT p.id, p.product, p.quantity FROM ProductInCart p WHERE p.cart.id = :id")
	List<Object[]> getProductInCartNotSold(long id);
}
