package com.mindtree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id", length = 30)
	private String customerId;

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(name = "email_id", length = 50, unique = true)
	private String emailId;

	@Column(name = "customer_id_proof_type", length = 30)
	private String customerIdProofType;

	@Column(name = "customer_id_proof", length = 30)
	private String customerIdProof;

	@Column(name = "preferred_category", length = 30)
	private String preferredCategory;

	@Column(name = "preferred_cuisine", length = 30)
	private String preferredCuisine;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonManagedReference
	private CustomerAddress customerAddress;

	public Customer() {
		/*
		 * Empty constructor for Hibernate to instantiate object
		 */

	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerAddress getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerIdProofType() {
		return customerIdProofType;
	}

	public void setCustomerIdProofType(String customerIdProofType) {
		this.customerIdProofType = customerIdProofType;
	}

	public String getCustomerIdProof() {
		return customerIdProof;
	}

	public void setCustomerIdProof(String customerIdProof) {
		this.customerIdProof = customerIdProof;
	}

	public String getPreferredCategory() {
		return preferredCategory;
	}

	public void setPreferredCategory(String preferredCategory) {
		this.preferredCategory = preferredCategory;
	}

	public String getPreferredCuisine() {
		return preferredCuisine;
	}

	public void setPreferredCuisine(String preferredCuisine) {
		this.preferredCuisine = preferredCuisine;
	}

}
