package com.mindtree.dto;

import com.mindtree.entity.Customer;
import com.mindtree.entity.CustomerAddress;

public class CustomerUpdateDTO {
	
	private Customer customer;
	
	private CustomerAddress customerAddress;
	
	public CustomerUpdateDTO() {
		
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
	

}
