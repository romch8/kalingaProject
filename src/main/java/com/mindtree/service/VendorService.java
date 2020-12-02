package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Vendor;

public interface VendorService {

	public List<Vendor> getVendor();

	public Vendor getVendorById(String vendorId);

	public void EditVendorById(String id, Vendor vendor);

}
