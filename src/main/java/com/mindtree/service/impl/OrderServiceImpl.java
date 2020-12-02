package com.mindtree.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.OrderDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Orders;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorFoodItems;
import com.mindtree.repository.CustomerRepository;
import com.mindtree.repository.OrderRepository;
import com.mindtree.repository.VendorFoodItemsRepository;
import com.mindtree.repository.VendorRepository;
import com.mindtree.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private VendorFoodItemsRepository vendorFoodItemsRepository;

	public void cart(OrderDTO orderDto)

	{
		Orders order = new Orders();

		Customer customer = null;

		Vendor vendor = null;

		List<Integer> idList = orderDto.getFoodItemIds();

		Optional optional;

		optional = customerRepository.findById(orderDto.getCustomerid());

		List<VendorFoodItems> orderedItems;

		if (optional.isPresent()) {
			customer = (Customer) optional.get();
		}

		optional = vendorRepository.findById(orderDto.getVendorid());

		if (optional.isPresent()) {
			vendor = (Vendor) optional.get();
		}

		orderedItems = (List<VendorFoodItems>) vendorFoodItemsRepository.findAllById(idList);

		order.setCustomer(customer);
		order.setVendor(vendor);
		order.setVendorFoodItems(orderedItems);
		order.setTotalBill(orderDto.getTotalBill());
		orderRepository.save(order);
	}

	@Override
	public List<Orders> getCustomerOrderDetailsById(String customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return orderRepository.findByCustomer(customer);
	}

	public List<Orders> getAllOrders() {
		return (List<Orders>) orderRepository.findAll();

	}

}
