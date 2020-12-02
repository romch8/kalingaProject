package com.mindtree.service;
import com.mindtree.dto.CustomerUpdateDTO;
import com.mindtree.entity.Customer;

public interface CustomerService 
{
	public Customer getCustomerById(String customerId);
	public void editCustomerById(String id, CustomerUpdateDTO customer);

}

	
