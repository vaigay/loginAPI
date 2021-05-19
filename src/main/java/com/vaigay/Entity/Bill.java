package com.vaigay.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	

	
	private String address;
	private Date crateDate;
	
	private double totalProductAmount;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public double getTotalProductAmount() {
		return totalProductAmount;
	}

	public void setTotalProductAmount(double totalProductAmount) {
		this.totalProductAmount = totalProductAmount;
	}

	public Date getCrateDate() {
		return crateDate;
	}

	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}


}
