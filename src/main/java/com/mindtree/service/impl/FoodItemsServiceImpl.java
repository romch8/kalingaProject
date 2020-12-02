package com.mindtree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.repository.FoodItemsRepository;
import com.mindtree.service.FoodItemsService;

@Service
public class FoodItemsServiceImpl implements FoodItemsService {

	@Autowired
	private FoodItemsRepository foodItemsRepository;

	@Override
	public List<String> itemsList() {
		return foodItemsRepository.findNames();

	}

}
