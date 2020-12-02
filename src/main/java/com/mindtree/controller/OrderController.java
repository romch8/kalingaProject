package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.OrderDTO;
import com.mindtree.entity.Orders;
import com.mindtree.service.OrderService;

@RestController
@RequestMapping(path="/order")
public class OrderController {
	@Autowired
	private OrderService os;
	

	@CrossOrigin(origins="*")

	@PostMapping("/post")
	public void insert(@RequestBody OrderDTO ordersDto)
	{
		os.cart(ordersDto);
	}
	
	@GetMapping("/getall")
	public List<Orders> getAll()
	{
		return os.getAllOrders();
	}

}
