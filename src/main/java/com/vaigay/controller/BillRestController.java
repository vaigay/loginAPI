package com.vaigay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaigay.DTO.BillDTO;
import com.vaigay.Entity.Cart;
import com.vaigay.service.BillService;
import com.vaigay.service.ProductInCartService;
import com.vaigay.service.UserChecking;

@RestController
public class BillRestController {

	@Autowired
	private UserChecking userChecking;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private ProductInCartService pInCartSer;
	
	@PostMapping("/bill")
	public ResponseEntity<?> createBill(@RequestBody BillDTO bDto){
		Cart cart = pInCartSer.getUserCart(userChecking.getIdUser());
		System.out.println(bDto.getAddress());
		if( bDto.getAddress() == null || bDto.getAddress().equals(""))
			return new ResponseEntity<String>("Your address is empty",HttpStatus.BAD_REQUEST);
		if(billService.isCartHasAnyProduct(cart))
			return new ResponseEntity<BillDTO>(billService.createBill(cart, bDto.getAddress()),HttpStatus.OK);
		return new ResponseEntity<String>("Your cart is empty",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/bill/{id}")
	public ResponseEntity<BillDTO> getOneBill(@PathVariable(value = "id") long id){;
		BillDTO bill = billService.getOneBill(id,userChecking.getIdUser());
		if(bill == null)
			return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<BillDTO>(bill,HttpStatus.OK);
	}
	
	@GetMapping("/bills")
	public ResponseEntity<List<BillDTO>> getAllBill(){
		return new ResponseEntity<List<BillDTO>>(billService.getAllBill(userChecking.getIdUser()),HttpStatus.OK);
	}
	
}
