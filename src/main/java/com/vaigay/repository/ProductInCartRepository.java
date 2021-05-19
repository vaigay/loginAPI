package com.vaigay.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import com.vaigay.Entity.ProductInCart;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
	
	@Query("SELECT p.id, p.product, p.quantity FROM ProductInCart p WHERE p.cart.id = :id")
	List<Object[]> getProductInCartNotSold(@Param("id") long  id);
	
	@Query("SELECT p.id, p.quantity FROM ProductInCart p WHERE p.product.id = :id ")
	Object[] getProductInCartQuantity(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE ProductInCart p set p.quantity = :quantity WHERE p.product.id = :id")
	void updateProductInCartQuantity(@Param("id")  long id,@Param("quantity")  int quantity);
	
	Optional<ProductInCart> findOneByProduct_id(long id);
	
	boolean existsByProduct_Id(long id);
	
	void deleteByProduct_Id(long id);
	
	int countByCart_Id(long id);
}
