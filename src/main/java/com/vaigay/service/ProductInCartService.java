package com.vaigay.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.ProductInCartDTO;
import com.vaigay.DTO.RequestProductInCart;
import com.vaigay.Entity.Cart;
import com.vaigay.Entity.ProductInCart;
import com.vaigay.Entity.User;
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
		Cart c = cartRepository.findByStatusAndUser_id(false, id).orElse(null);
		if(c == null) {
			c = new Cart();
			User u = new User();
			u.setId(id);
			c.setUser(u);
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
	
	public void addProductToCart(RequestProductInCart productAddToCart,long idUser) {
		long idCart = getUserCart(idUser).getId();
		ProductInCart tmp =  productInCartRepository.findOneByCart_IdAndProduct_Id(idCart, productAddToCart.getIdProduct()).orElse(null);
		int quantity = 0;
		long id = 0;
		if(tmp != null) {
			id = tmp.getId();
			quantity = tmp.getQuantity();
		}
		int tmpQuantity = productAddToCart.getQuantity();
		productAddToCart.setQuantity(quantity + tmpQuantity);
		productInCartRepository.save(pInCartConverter.toEntity(productAddToCart.getIdProduct(),productAddToCart.getQuantity(), idCart, id));
	}
	
	public boolean checkExistsProductInCart(long id) {
		return productInCartRepository.existsByProduct_Id(id);
	}
	
	public void updateProductInCartQuantity(RequestProductInCart pCartDTO) {
		productInCartRepository.updateProductInCartQuantity(pCartDTO.getIdProduct(), pCartDTO.getQuantity());
	}
	
	public boolean deleteProductIncart(long id) {
		if(productInCartRepository.existsById(id)) {
			productInCartRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
