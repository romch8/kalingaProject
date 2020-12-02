package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.CustomerSignupDTO;
import com.mindtree.dto.SignupResponseDTO;
import com.mindtree.dto.VendorSignupDTO;
import com.mindtree.entity.OTP;
import com.mindtree.entity.State;
import com.mindtree.service.impl.SignupServiceImpl;

@RestController
@RequestMapping(path="/signup")
public class SignupController {
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	/*
	 * To register a customer
	 */
	@CrossOrigin
	@PostMapping(path = "/customer")
	public SignupResponseDTO registerCustomer(@RequestBody CustomerSignupDTO customerDto) {
		try {
			return signupServiceImpl.registerCustomer(customerDto);
		} catch (Exception e) {
			return new SignupResponseDTO("failure", "Unable to register the user. Please verify details or try again later.", customerDto.getCustomer().getEmailId());
		}
	}

	/*
	 * To register a vendor
	 */
	@CrossOrigin
	@PostMapping(path = "/vendor")
	public SignupResponseDTO registerVendor(@RequestBody VendorSignupDTO vendorDto) {
		try {
			return signupServiceImpl.registerVendor(vendorDto);
		} catch (Exception e) {
			return new SignupResponseDTO("failure", "Unable to register the user. Please verify details or try again later.", vendorDto.getVendor().getEmailId());
		}
	}
	
	/*
	 *To verify both customer and vendor 
	 */
	@CrossOrigin
	@PostMapping(path = "/verify")
	public SignupResponseDTO verify(@RequestBody OTP otp) {
		return signupServiceImpl.verifyOtp(otp);
	}
	
	@CrossOrigin
	@PostMapping(path = "/states")
	public void addState(@RequestBody State state) {
		signupServiceImpl.addState(state);
	}
	
	@CrossOrigin
	@GetMapping(path = "/states")
	public List<State> getStates(){
		return signupServiceImpl.getStates();
	}
	
}
