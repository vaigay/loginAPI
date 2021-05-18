package com.vaigay.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vaigay.DTO.ProductDTO;
import com.vaigay.Entity.Product;

@Component
public class ProductConverter {
		
	
	public ProductDTO toDTO(Product product) {
		ProductDTO p = new ProductDTO();
		p.setId(product.getId());
		p.setBrand(product.getBrand());
		p.setImageURL(product.getImageURL());
		p.setName(product.getName());
		p.setMadein(product.getMadein());
		p.setDescription(product.getDescription());
		return p;
	}
	
	public Product toEntity(ProductDTO productDTO) {
		Product p = new Product();
		p.setId(productDTO.getId());
		p.setBrand(productDTO.getBrand());
		p.setImageURL(productDTO.getImageURL());
		p.setName(productDTO.getName());
		p.setMadein(productDTO.getMadein());
		p.setDescription(productDTO.getDescription());
		return p;
	}
	
	public List<ProductDTO> toListDTO(List<Product> products){
		if(products == null)
			return null;
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for(Product product : products){
			dtos.add(toDTO(product));
		}
		return dtos;
	}
	
	public List<Product> toListEntity(List<ProductDTO> dtos){
		if(dtos == null)
			return null;
		List<Product> products = new ArrayList<Product>();
		for(ProductDTO dto : dtos)
			products.add(toEntity(dto));
		return products;
	}
}
