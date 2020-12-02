package com.mindtree.dto;

import com.mindtree.entity.Customer;
import com.mindtree.entity.CustomerAddress;
import com.mindtree.entity.Login;

public class CustomerSignupDTO {
	
	private Customer customer;
	
	private CustomerAddress customerAddress;
	
	private Login login;

	public CustomerSignupDTO() {
		
		 
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
