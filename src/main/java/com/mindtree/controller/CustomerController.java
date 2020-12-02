package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.CustomerUpdateDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Orders;
import com.mindtree.service.CustomerService;
import com.mindtree.service.OrderService;

@RestController
@RequestMapping(path="/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin(origins="*")
	@GetMapping(path="customer/{customerId}")
	public Customer getCustomerDetailsById(@PathVariable String customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(path="customer/update/{customerId}")
	public String updateCustomer(@PathVariable String  customerId, @RequestBody CustomerUpdateDTO customer){
		customerService.editCustomerById( customerId,customer);
		return "Success";
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/customer/order/{customerId}")
	public List<Orders> getCusOrderDetailsById(@PathVariable String customerId){
		return orderService.getCustomerOrderDetailsById(customerId);
	}
}
