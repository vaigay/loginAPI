package com.vaigay.DTO;

import java.sql.Date;
import java.util.List;

public class BillDTO {
	public BillDTO(long id, String address, Date crateDate, double totalProductAmount,
			List<ProductHasSoldDTO> listProductHasSoldDTOs) {
		super();
		this.id = id;
		this.address = address;
		this.crateDate = crateDate;
		this.totalProductAmount = totalProductAmount;
		this.listProductHasSoldDTOs = listProductHasSoldDTOs;
	}
	public BillDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private long id;
	private String address;
	private Date crateDate;
	private double totalProductAmount;
	private List<ProductHasSoldDTO> listProductHasSoldDTOs;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCrateDate() {
		return crateDate;
	}
	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}
	public double getTotalProductAmount() {
		return totalProductAmount;
	}
	public void setTotalProductAmount(double totalProductAmount) {
		this.totalProductAmount = totalProductAmount;
	}
	
	public List<ProductHasSoldDTO> getListProductHasSoldDTOs() {
		return listProductHasSoldDTOs;
	}
	public void setListProductHasSoldDTOs(List<ProductHasSoldDTO> listProductHasSoldDTOs) {
		this.listProductHasSoldDTOs = listProductHasSoldDTOs;
	}
	
	
}
