package com.mindtree.dto;

import com.mindtree.entity.FoodItems;
import com.mindtree.entity.Vendor;

public class VendorMenuDTO {

	private Vendor vendor;
	
	private FoodItems foodItems;

	private double price;

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public FoodItems getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(FoodItems foodItems) {
		this.foodItems = foodItems;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
