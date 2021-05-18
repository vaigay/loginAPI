package com.vaigay.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	
	public Cart(long id, User user, List<ProductInCart> productInCarts, boolean status) {
		super();
		this.id = id;
		this.user = user;
		this.productInCarts = productInCarts;
		this.status = status;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private List<ProductInCart> productInCarts;
	
	
	
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ProductInCart> getProductInCarts() {
		return productInCarts;
	}

	public void setProductInCarts(List<ProductInCart> productInCarts) {
		this.productInCarts = productInCarts;
	}
	
}
