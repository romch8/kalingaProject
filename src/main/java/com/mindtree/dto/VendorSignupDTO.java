package com.mindtree.dto;

import com.mindtree.entity.Login;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorAddress;

public class VendorSignupDTO {
	
	private Vendor vendor;
	
	private VendorAddress vendorAddress;
	
	private Login login;
	
	public VendorSignupDTO() {
		/*
		 * Empty constructor for object creation
		 */
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public VendorAddress getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddress vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
