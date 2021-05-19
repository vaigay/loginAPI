package com.vaigay.DTO;

import com.vaigay.Entity.ProductInCart;

public class ProductHasSoldDTO {
	
	public ProductHasSoldDTO(ProductInCart product) {
		this.id = product.getId();
		this.name = product.getName();
		this.brand = product.getBrand();
		this.madein = product.getMadein();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.imageURL = product.getImageURL();
	}

	public ProductHasSoldDTO(long id, String name, String brand, String madein, double price, int quantity,
			String imageURL) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
		this.quantity = quantity;
		this.imageURL = imageURL;
	}

	private long id;
	private String name;
    private String brand;
    private String madein;
    private double price;
    private int quantity;
    
    private String imageURL;
    


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	
}


