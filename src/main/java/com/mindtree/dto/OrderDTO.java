package com.mindtree.dto;

import java.util.List;

public class OrderDTO {
	private double totalBill;
	private String customerid;
	private String vendorid;
	private List<Integer> foodItemIds;
	
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getVendorid() {
		return vendorid;
	}
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public List<Integer> getFoodItemIds() {
		return foodItemIds;
	}
	public void setFoodItemIds(List<Integer> foodItemIds) {
		this.foodItemIds = foodItemIds;
	}
	
}