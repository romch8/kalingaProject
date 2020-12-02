package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signup_counter")
public class SignupCounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "vendor_count")
	private int vendorCount;

	@Column(name = "customer_count")
	private int customerCount;

	public SignupCounter() {
		/*
		 * Empty constructor for Hibernate to instantiate object
		 */
	}

	public int getVendorCount() {
		return vendorCount;
	}

	public void setVendorCount(int vendorCount) {
		this.vendorCount = vendorCount;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

}
