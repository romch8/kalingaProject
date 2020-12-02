package com.mindtree.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.dto.OrderDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

	ArrayList<Orders> findByCustomer(Customer customer);

	void save(List<OrderDTO> orderlist);

}
