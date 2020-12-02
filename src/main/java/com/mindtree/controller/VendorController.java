package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Vendor;
import com.mindtree.service.VendorService;

@RestController
@RequestMapping(path = "/")
public class VendorController {
	@Autowired
	private VendorService vendorService;

	@CrossOrigin(origins = "*")
	@GetMapping(path = "vendor/{vendorId}")
	public Vendor getVendorDetailsById(@PathVariable String vendorId) {
		return vendorService.getVendorById(vendorId);
	}

	@PutMapping("vendor/{id}")
	public String updateVendor(@PathVariable String id, @RequestBody Vendor vendor) {
		vendorService.EditVendorById(id, vendor);
		return "Success";

	}

}
