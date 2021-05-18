package com.vaigay.DTO;

public class ProductInCartDTO {
	public ProductInCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInCartDTO(long id, ProductDTO productDTO, int quantity) {
		super();
		this.id = id;
		this.productDTO = productDTO;
		this.quantity = quantity;
	}
	private long id;
	private ProductDTO productDTO;
	private int quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
