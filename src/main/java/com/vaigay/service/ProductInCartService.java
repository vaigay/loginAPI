package com.vaigay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.ProductInCartDTO;
import com.vaigay.Entity.Cart;
import com.vaigay.Entity.ProductInCart;
import com.vaigay.converter.ProductInCartConverter;
import com.vaigay.repository.CartRepository;
import com.vaigay.repository.ProductInCartRepository;

@Service
public class ProductInCartService {
	
	@Autowired
	private ProductInCartRepository productInCartRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductInCartConverter pInCartConverter;
	
	public Cart getUserCart(long id) {
		Cart c = cartRepository.findByStatusAndUser_id(null, id).orElse(null);
		if(c == null) {
			c = new Cart();
			c.setStatus(false);
			cartRepository.save(c);
		}
		return c;
	}
	
	public List<ProductInCartDTO> getListProductInCartDTO(long id){
		Cart c = getUserCart(id);
		List<Object[]> productInCarts = productInCartRepository.getProductInCartNotSold(c.getId());
		List<ProductInCartDTO> dtos = pInCartConverter.toListDTONotSold(productInCarts);
		return dtos;
	}
	
}
