package com.mindtree.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.dto.CustomerUpdateDTO;
import com.mindtree.entity.Customer;
import com.mindtree.repository.CustomerRepository;
import com.mindtree.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;

	// Get Specific customer By Id
	@Override
	public Customer getCustomerById(String customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer cust = new Customer();
		if(customer.isPresent()) {
			cust = customer.get();
		}
		return  cust;
	}

	// Edit Specific customer By Id
	@Override
	public void editCustomerById(@PathVariable String  customerId, @RequestBody CustomerUpdateDTO customer ) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		
		Customer cust1 = new Customer();
		if(opt.isPresent()) 
		{
	    customer.getCustomer().setCustomerId(opt.get().getCustomerId());  
	    customer.getCustomerAddress().setId(opt.get().getCustomerAddress().getId());
	    customer.getCustomer().setEmailId(opt.get().getEmailId());
	    cust1.setCustomerId(customer.getCustomer().getCustomerId());
	    cust1.setCustomerIdProof(customer.getCustomer().getCustomerIdProof());
	    cust1.setCustomerIdProofType(customer.getCustomer().getCustomerIdProofType());
	    cust1.setEmailId(customer.getCustomer().getEmailId());
	    cust1.setFirstName(customer.getCustomer().getFirstName());
	    cust1.setLastName(customer.getCustomer().getLastName());
	    cust1.setPreferredCategory(customer.getCustomer().getPreferredCategory());
	    cust1.setPreferredCuisine(customer.getCustomer().getPreferredCuisine());
	    cust1.setCustomerAddress(customer.getCustomerAddress());
		}
		System.out.println(customer.getCustomer());
		System.out.println(cust1.getFirstName());
		customerRepository.save(cust1);
	}
}
