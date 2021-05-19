package com.vaigay.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaigay.DTO.ProductInCartDTO;
import com.vaigay.Entity.Cart;
import com.vaigay.Entity.Product;
import com.vaigay.Entity.ProductInCart;


@Component
public class ProductInCartConverter {
	
	@Autowired
	private ProductConverter pConverter;
	
	public ProductInCartDTO toDTO(long id, Product product,int quantity) {
		ProductInCartDTO pDto = new ProductInCartDTO();
		pDto.setProductDTO(pConverter.toDTO(product));
		pDto.setId(id);
		pDto.setQuantity(quantity);
		return pDto;
	}
	
	
	public List<ProductInCartDTO> toListDTONotSold(List<Object[]> productInCarts){
		List<ProductInCartDTO> dtos = new ArrayList<ProductInCartDTO>();
		for(Object[] tmp : productInCarts){
			System.out.println(tmp[0].toString());
			long id = Long.parseLong(tmp[0].toString());
			Product product = (Product) tmp[1];
			int quantity = Integer.parseInt(tmp[2].toString());
			dtos.add(toDTO(id, product, quantity));
		}
		return dtos;
	}
	
	
	
	
	public ProductInCart toEntity(long idProduct, int quantity, long idCart,Long  id) {
		ProductInCart pCart = new ProductInCart();
//		pCart.setId(dto.getId());
		if(id != 0)
			pCart.setId(id);
		Product p = new Product();
		p.setId(idProduct);
		pCart.setProduct(p);
		pCart.setQuantity(quantity);
		Cart c = new Cart();
		c.setId(idCart);
		pCart.setCart(c);
		return pCart;
	}
	
}
