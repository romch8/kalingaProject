package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vendor")
public class Vendor {

	@Id
	@Column(name = "vendor_id", length = 30)
	private String vendorId;

	@Column(name = "email_id", length = 50, unique = true)
	private String emailId;

	@Column(name = "name", length = 30)
	private String name;

	@Column(name = "rating")
	private double rating;

	@Column(name = "min_delivery_time", length = 15)
	private String minDeliveryTime;

	@Column(name = "min_order_amount")
	private int minOrder;

	@Column(name = "opening_time", length = 20)
	private String openingTime;
	
	@Column(name = "closing_time", length = 20)
	private String closingTime;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "num_of_tables")
	private int numOfTables;

	@Column(name = "category", length = 20)
	private String category;

	@Column(name = "main_cuisine_type", length = 30)
	private String mainCuisineType;

	@Column(name = "registration_id", length = 30, unique = true)
	private String registrationId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vendor")
	@JsonManagedReference
	private VendorAddress vendorAddress;

//	@LazyCollection(LazyCollectionOption.FALSE)
//	@JsonBackReference
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "vendor")
	private List<VendorFoodItems> vendorFoodItems;

	public Vendor() {
		/*
		 * Empty constructor for Hibernate to instantiate object
		 */
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getMinDeliveryTime() {
		return minDeliveryTime;
	}

	public void setMinDeliveryTime(String minDeliveryTime) {
		this.minDeliveryTime = minDeliveryTime;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public int getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(int minOrder) {
		this.minOrder = minOrder;
	}

	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getNumOfTables() {
		return numOfTables;
	}

	public void setNumOfTables(int numOfTables) {
		this.numOfTables = numOfTables;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMainCuisineType() {
		return mainCuisineType;
	}

	public void setMainCuisineType(String mainCuisineType) {
		this.mainCuisineType = mainCuisineType;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public List<VendorFoodItems> getVendorFoodItems() {
		return vendorFoodItems;
	}

	@JsonIgnore
	public void setVendorFoodItems(List<VendorFoodItems> vendorFoodItems) {
		this.vendorFoodItems = vendorFoodItems;
	}

}