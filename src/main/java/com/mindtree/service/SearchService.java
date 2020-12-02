package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorFoodItems;

public interface SearchService {

	List<String> citynames();

	List<Vendor> restaurants(String keyword, String city);

	List<VendorFoodItems> items(String vendorid);

}
