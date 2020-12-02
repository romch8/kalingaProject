package com.mindtree.service;

import java.util.List;

import com.mindtree.dto.CustomerSignupDTO;
import com.mindtree.dto.SignupResponseDTO;
import com.mindtree.dto.VendorSignupDTO;
import com.mindtree.entity.OTP;
import com.mindtree.entity.State;

public interface SignupService {
	
	SignupResponseDTO verifyOtp(OTP otpIncoming);
	
	SignupResponseDTO registerVendor(VendorSignupDTO vendorDto) throws Exception;
	
	SignupResponseDTO registerCustomer(CustomerSignupDTO customerDto) throws Exception;
	
	void addState(State state);
	
	List<State> getStates();

}
