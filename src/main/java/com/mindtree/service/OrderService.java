package com.mindtree.service;

import java.util.List;

import com.mindtree.dto.OrderDTO;
import com.mindtree.entity.Orders;

public interface OrderService {


	void cart(OrderDTO orders);

	List<Orders> getCustomerOrderDetailsById(String customerId);

	List<Orders> getAllOrders();

}
