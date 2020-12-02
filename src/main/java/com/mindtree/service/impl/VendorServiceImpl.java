package com.mindtree.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Vendor;
import com.mindtree.repository.VendorRepository;
import com.mindtree.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public List<Vendor> getVendor() {
		return (List<Vendor>) vendorRepository.findAll();
	}

	@Override
	public Vendor getVendorById(String vendorId) {
		Optional<Vendor> vendor = vendorRepository.findById(vendorId);
		Vendor vend = null;
		if(vendor.isPresent()) {
			vend = vendor.get();
		}
		return  vend;
	}

	@Override
	public void EditVendorById(String id, Vendor vendor) {
		Optional<Vendor> vendorOptional = vendorRepository.findById(id);
		vendorRepository.save(vendor);

		
	}

}
