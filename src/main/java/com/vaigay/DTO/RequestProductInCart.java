package com.vaigay.DTO;

public class RequestProductInCart {

	public RequestProductInCart(long idProduct, int quantity) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	public RequestProductInCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	private long idProduct;
	private int quantity;
	
	
	
	
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
