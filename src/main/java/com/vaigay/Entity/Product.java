package com.vaigay.Entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	public Product(long id, String name, String brand, String madein, double price, String description, String imageURL,
			List<ProductInCart> productInCarts) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
		this.description = description;
		this.imageURL = imageURL;
		this.productInCarts = productInCarts;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
    private String brand;
    private String madein;
    private double price;
    private String description;
    private String imageURL;
    
    @OneToMany(mappedBy = "product")
    private List<ProductInCart> productInCarts;

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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductInCart> getProductInCarts() {
		return productInCarts;
	}

	public void setProductInCarts(List<ProductInCart> productInCarts) {
		this.productInCarts = productInCarts;
	}
}
