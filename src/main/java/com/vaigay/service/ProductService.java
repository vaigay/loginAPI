package com.vaigay.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vaigay.DTO.ProductDTO;
import com.vaigay.Entity.Product;
import com.vaigay.converter.ProductConverter;
import com.vaigay.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter pConverter;
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@Value("${folder.image}")
	private String folderImage;
	
	
	public List<ProductDTO> getAllProduct(){
		List<Product> products = productRepository.findAll();
		return pConverter.toListDTO(products);
	}
	
	public ProductDTO saveProduct(ProductDTO productDTO,MultipartFile upload) throws IOException {	
		productDTO.setImageURL(saveImage(upload));
		Product p = pConverter.toEntity(productDTO);
		saveOneProduct(p);
		productDTO.setId(p.getId());
		return productDTO;
	}
	
	public void saveOneProduct(Product p) {
		productRepository.save(p);
	}
	
	public Product getProductById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	public void updateProduct(Product product, ProductDTO productDTO,long id,MultipartFile upload) throws IOException {
		product = pConverter.toEntity(productDTO);
		product.setId(id);
		product.setImageURL(saveImage(upload));
		productDTO.setImageURL(product.getImageURL());
		productRepository.save(product);
	}
	
	public ProductDTO getProductDTOById(long id) {
		Product product =getProductById(id);
		if(product == null)
			return null;
		return pConverter.toDTO(product);
	}
	
	public boolean checkProductExists(long id) {
		return productRepository.existsById(id);
	}
	
	
	public Map<String, Object> getPageProduct(Integer page, Integer limit){
		int p,l;
		productRepository.getOne((long) 1);
		if(page == null)
			p = 1;
		else
			p = page;
		if(limit == null)
			l = 5;
		else
			l = limit;
		System.out.println(p + " " + l);
		Pageable pageable =  (Pageable) PageRequest.of(p - 1, l);
		Page<Product> tmp = productRepository.findAll(pageable);
		List<Product> products = tmp.getContent();
		long x = productRepository.count();
		long totalPage =  x / l;
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("totalPage", totalPage);
		m.put("currentPage",p);
		m.put("products", pConverter.toListDTO(products));
		return m;
	}
	
	private String saveImage(MultipartFile upload) throws IOException {
		if(upload != null) {
			String sourceName = upload.getOriginalFilename();
			String desFileName = RandomStringUtils.randomAlphabetic(5).concat(".").concat(sourceName);
			Path path = Paths.get(uploadPath);
			try {
				InputStream inputStream = upload.getInputStream();
				Files.copy(inputStream, path.resolve(desFileName), StandardCopyOption.REPLACE_EXISTING);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return desFileName;
		}
		return null;
	}
	
	
	
}
