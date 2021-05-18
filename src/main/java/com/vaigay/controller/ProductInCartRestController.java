package com.vaigay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaigay.DTO.ProductInCartDTO;
import com.vaigay.service.ProductInCartService;
import com.vaigay.service.UserChecking;

@RestController
public class ProductInCartRestController {
	
	@Autowired
	private UserChecking userChecking;
	
	@Autowired
	private ProductInCartService pCartService;
	
	
	@GetMapping("/productInCart")
	public ResponseEntity<List<ProductInCartDTO>> getCart(){
		List<ProductInCartDTO> dtos = pCartService.getListProductInCartDTO(userChecking.getUserPrincipal().getUserId());
		return new ResponseEntity<List<ProductInCartDTO>>(dtos,HttpStatus.OK);
	}
	
}
