package com.vaigay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaigay.DTO.ProductInCartDTO;

import com.vaigay.DTO.RequestProductInCart;
import com.vaigay.service.ProductInCartService;
import com.vaigay.service.ProductService;
import com.vaigay.service.UserChecking;

@RestController
public class ProductInCartRestController {
	
	@Autowired
	private UserChecking userChecking;
	
	@Autowired
	private ProductInCartService pCartService;
	
	@Autowired
	private ProductService pService;
	
	
	@GetMapping("/productInCart")
	public ResponseEntity<List<ProductInCartDTO>> getCart(){
		List<ProductInCartDTO> dtos = pCartService.getListProductInCartDTO(userChecking.getUserPrincipal().getUserId());
		return new ResponseEntity<List<ProductInCartDTO>>(dtos,HttpStatus.OK);
	}
	
	@PostMapping("/productInCart") // thêm Product vào cart
	public ResponseEntity<String> addProductToCart(@RequestBody RequestProductInCart productAddToCart){
		System.out.println("11111111111111111111111111111111");
		if(!pService.checkProductExists(productAddToCart.getIdProduct()))
			return new ResponseEntity<String>("Product Invalid",HttpStatus.NOT_FOUND);
		System.out.println("222222222222222222222");
		if(productAddToCart.getQuantity() <= 0)
			return new ResponseEntity<String>("Product Invalid",HttpStatus.BAD_GATEWAY);
		System.out.println("3333333333333333333333");
		pCartService.addProductToCart(productAddToCart,userChecking.getIdUser());
		System.out.println("4444444444444444444444");
		return new ResponseEntity<String>("Add Product Successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/productInCart")// chỉnh sửa số lượng của 1 sản phẩm trong cart (theo id của Product trong ProductICart )
	public ResponseEntity<?> updateProductInCartQuantity(@RequestBody RequestProductInCart  pUpdate){
		if(!pCartService.checkExistsProductInCart(pUpdate.getIdProduct()))
			return new ResponseEntity<String>("Cart doesn't have this product",HttpStatus.NOT_FOUND);
		if(pUpdate.getQuantity() <= 0)
			return new ResponseEntity<String>("Invalid Quantity",HttpStatus.BAD_REQUEST);
		pCartService.updateProductInCartQuantity(pUpdate);
		List<ProductInCartDTO> dtos = pCartService.getListProductInCartDTO(userChecking.getUserPrincipal().getUserId());
		return new ResponseEntity<List<ProductInCartDTO>>(dtos,HttpStatus.OK);
	}
	
	@DeleteMapping("/productInCart/{id}")// xoá 1 ProductInCart theo id ProductInCart
	public ResponseEntity<?> deleteProductInCart(@PathVariable(value = "id") long id){
		if(pCartService.deleteProductIncart(id)) {
			List<ProductInCartDTO> dtos = pCartService.getListProductInCartDTO(userChecking.getUserPrincipal().getUserId());
			return new ResponseEntity<List<ProductInCartDTO>>(dtos,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Product is not in cart!",HttpStatus.NOT_FOUND);
	}
}
