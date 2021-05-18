package com.vaigay.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vaigay.DTO.ProductDTO;
import com.vaigay.Entity.Product;
import com.vaigay.service.ProductService;

@CrossOrigin
@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		return new ResponseEntity<List<ProductDTO>>(productService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getAllProduct(@PathVariable(name = "id") long id) {
		ProductDTO p = productService.getProductDTOById(id);
		System.out.println(":123123");
		if (p == null)
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ProductDTO>(p, HttpStatus.OK);
	}

	@PostMapping("/product")
	public ResponseEntity<ProductDTO> saveProduct( ProductDTO productDTO,@RequestParam(value = "image" , required = false) MultipartFile upload) {
		try {
			return new ResponseEntity<ProductDTO>(productService.saveProduct(productDTO,upload), HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<ProductDTO>( HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @RequestParam(value = "image" , required = false) MultipartFile upload,
			@PathVariable(name = "id") long id) {
		Product product = productService.getProductById(id);
		if (product == null)
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		productService.updateProduct(product, productDTO, id);
		productDTO.setId(id);
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}

	@GetMapping("/productPage")
	public ResponseEntity<Map<String, Object>> getPage(@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		return new ResponseEntity<Map<String, Object>>(productService.getPageProduct(page, limit), HttpStatus.OK);
	}

}
