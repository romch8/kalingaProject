package com.mindtree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorFoodItems;
import com.mindtree.service.FoodItemsService;
import com.mindtree.service.SearchService;

@RestController
@RequestMapping(path = "/search")
public class SearchController {
	@Autowired
	SearchService services;
	@Autowired
	FoodItemsService fooditemservice;

	// List Of different items provided by the restaurant

	@CrossOrigin
	@GetMapping(path = "/items")
	public List<String> searchItems() {
		return fooditemservice.itemsList();

	}

	// List of different cities

	@CrossOrigin
	@GetMapping(path = "/cities")
	public List<String> cities() {
		return services.citynames();

	}

	// List of restaurant based on city and item name

	@CrossOrigin
	@GetMapping(path = "/items/{selectedItem}/{selectedCity}")
	public List<Vendor> restaurantList(@PathVariable String selectedItem, @PathVariable String selectedCity) {

		List<Vendor> vendors = new ArrayList<Vendor>();

		vendors = services.restaurants(selectedItem, selectedCity);

		return vendors;
	}

	// List of items based on restaurant item name

	@CrossOrigin
	@GetMapping(path = "/items/{vendorid}")
	public List<VendorFoodItems> itemsList(@PathVariable String vendorid) {
		return services.items(vendorid);
	}

}
