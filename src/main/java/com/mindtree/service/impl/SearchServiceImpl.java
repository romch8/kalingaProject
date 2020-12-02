package com.mindtree.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.FoodItems;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorFoodItems;
import com.mindtree.repository.FoodItemsRepository;
import com.mindtree.repository.SearchRepository;
import com.mindtree.repository.VendorAddressRepository;
import com.mindtree.repository.VendorFoodItemsRepository;
import com.mindtree.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchRepository searchRepository;
	@Autowired
	VendorAddressRepository vendorrepository;
	@Autowired
	VendorFoodItemsRepository vendorfoodrepository;

	@Autowired
	FoodItemsRepository foodItemsRepository;

	@Override
	public List<String> citynames() {

		return vendorrepository.findcitynames();
	}

	@Override
	public List<Vendor> restaurants(String keyword, String city) {

		FoodItems food = foodItemsRepository.findByName(keyword);
		List<Vendor> vends = searchRepository.findByVendorAddressCity(city);
		try {
			List<VendorFoodItems> vendorsFood = food.getVendorFoodItems();

			List<Vendor> vendors = new ArrayList<Vendor>();

			for (VendorFoodItems v : vendorsFood) {

				vendors.add(v.getVendor());
			}

			if (vendors != null) {
				vends.retainAll(vendors);
			}

		} catch (Exception e) {

		}
		return vends;
	}

	@Override
	public List<VendorFoodItems> items(String vendorid) {
		return vendorfoodrepository.findByVendorFoodItems(vendorid);
	}

}
