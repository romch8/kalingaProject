package com.mindtree.service.impl;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.CustomerSignupDTO;
import com.mindtree.dto.SignupResponseDTO;
import com.mindtree.dto.VendorSignupDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.CustomerAddress;
import com.mindtree.entity.Login;
import com.mindtree.entity.OTP;
import com.mindtree.entity.SignupCounter;
import com.mindtree.entity.State;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorAddress;
import com.mindtree.repository.CustomerRepository;
import com.mindtree.repository.LoginRepository;
import com.mindtree.repository.OTPRepository;
import com.mindtree.repository.SignupCounterRepository;
import com.mindtree.repository.StateRepository;
import com.mindtree.repository.VendorRepository;
import com.mindtree.service.SignupService;
import com.mindtree.utils.PasswordUtils;
import com.mindtree.utils.SignupUtils;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private SignupCounterRepository signupCounterRepository;
	
	@Autowired
	private OTPRepository otpRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	private Customer customer;
	
	private CustomerAddress customerAddress;
	
	private Vendor vendor;
	
	private VendorAddress vendorAddress;
	
	private Login login;

	private SignupUtils signupUtils = new SignupUtils();
	
	private OTP otp;
	
	String password;
	
	String salt;
	
	String encryptedPassword;
	
	private PasswordUtils passwordUtils = new PasswordUtils(); 
	
	public SignupResponseDTO registerCustomer(CustomerSignupDTO customerDto) throws Exception {
		SignupCounter signupCounter = new SignupCounter();
		SignupResponseDTO response = new SignupResponseDTO();
		
		Optional<SignupCounter> options;
		int customerCount = 1000;
		
		try {
		options = signupCounterRepository.findById(1);
		if(options.isPresent()) {
			signupCounter = options.get();
			customerCount = signupCounter.getCustomerCount(); 
		}
		}
		catch(NullPointerException e) {
			signupCounter = new SignupCounter();
			signupCounter.setCustomerCount(customerCount);
			signupCounter = signupCounterRepository.save(signupCounter);
		}
		customerCount++;
		signupCounter.setCustomerCount(customerCount);
		
		customer = customerDto.getCustomer();
		customer.setCustomerId("cust"+ String.valueOf(customerCount));
		
		password = customerDto.getLogin().getPassword();
		
	    salt = passwordUtils.getSalt(30);
	    
        encryptedPassword = passwordUtils.generateSecurePassword(password, salt);
        
		customerAddress = customerDto.getCustomerAddress();
		customerAddress.setCustomer(customer);
		login = customerDto.getLogin();
		login.setUserId(customer.getCustomerId());
		login.setUserName(customer.getFirstName() + " "+ customer.getLastName());
		login.setEmailId(customer.getEmailId());
		login.setPassword(encryptedPassword);
		login.setSalt(salt);
		
		customer.setCustomerAddress(customerAddress);

		if(customerRepository.save(customer) != null) {
			loginRepository.save(login);
			signupCounterRepository.save(signupCounter);
			try {
				otp = signupUtils.sendMail(customer.getEmailId(),"signup");
			} catch (MessagingException e) {
				response.setStatus("failure");
				response.setMessage("Registered Successfully. Unable to send verification email. Please try again later!!");
				response.setEmail(customer.getEmailId());
				return response;
			}
			otpRepository.save(otp);
			response.setStatus("success");
			response.setEmail(customer.getEmailId());
			response.setMessage("Successfully registered. Please check email for verifying account.");
			return response;
		}
		else {
			response.setStatus("failure");
			response.setMessage("Email already registered.");
			return response;
		}
	}

	public SignupResponseDTO registerVendor(VendorSignupDTO vendorDto) throws Exception {
		SignupCounter signupCounter = new SignupCounter();
		
		SignupResponseDTO response = new SignupResponseDTO();
		
		Optional<SignupCounter> options;
		int vendorCount = 1000;
		
		try {
		options = signupCounterRepository.findById(1);
		if(options.isPresent()) {
			signupCounter = options.get();
			vendorCount = signupCounter.getVendorCount(); 
		}
		}
		catch(NullPointerException e) {
			signupCounter = new SignupCounter();
			signupCounter.setCustomerCount(vendorCount);
			signupCounter = signupCounterRepository.save(signupCounter);
		}
		vendorCount++;
		
		vendor = vendorDto.getVendor();
		vendor.setVendorId("vend"+vendorCount);
		signupCounter.setVendorCount(vendorCount);
		
		password = vendorDto.getLogin().getPassword();
        
	    salt = passwordUtils.getSalt(30);
	        
        encryptedPassword = passwordUtils.generateSecurePassword(password, salt);
		
		vendorAddress = vendorDto.getVendorAddress();
		vendorAddress.setVendor(vendor);
		login = vendorDto.getLogin();
		login.setEmailId(vendor.getEmailId());
		login.setUserId(vendor.getVendorId());
		login.setUserName(vendor.getName());
		login.setPassword(encryptedPassword);
		login.setSalt(salt);
		vendor.setVendorAddress(vendorAddress);
		if(vendorRepository.save(vendor) != null) {
			loginRepository.save(login);
			signupCounterRepository.save(signupCounter);
			try {
				otp = signupUtils.sendMail(vendor.getEmailId(),"signup");
			} catch (MessagingException e) {
				response.setStatus("failure");
				response.setMessage("Registered Successfully. Unable to send verification email. Please try again later!!");
				return response;
			}
			otpRepository.save(otp);
			
			response.setStatus("success");
			response.setEmail(vendor.getEmailId());
			response.setMessage("Successfully registered. Please check email for verifying account.");
			return response;
		}
		else {
			response.setStatus("failure");
			response.setMessage("Email already registered.");
			return response;
		}
	}
	
	public SignupResponseDTO verifyOtp(OTP otpIncoming) {
		Optional<Login> optionLogin;
		otp = otpRepository.findByEmailId(otpIncoming.getEmailId());
		if(otp != null && otp.getOtp().equals(otpIncoming.getOtp())) {
			 optionLogin = loginRepository.findById(otp.getEmailId());
			 if(optionLogin.isPresent()) {
				 login = optionLogin.get();
				 login.setStatus("verified");
				 loginRepository.save(login);
				 otpRepository.deleteById(otp.getId());
			 }
			 return new SignupResponseDTO("success", "Successfully verified. Please login", otpIncoming.getEmailId());
		}else {
			return new SignupResponseDTO("failure", "Verification failed. Try again later", otpIncoming.getEmailId());
		}
	}

	@Override
	public void addState(State state) {
		stateRepository.save(state);
	}

	@Override
	public List<State> getStates() {
		return (List<State>) stateRepository.findAll();
	}

}
