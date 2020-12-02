
package com.mindtree.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.controller.SignupController;
import com.mindtree.dto.CustomerSignupDTO;
import com.mindtree.dto.SignupResponseDTO;
import com.mindtree.dto.VendorSignupDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.CustomerAddress;
import com.mindtree.entity.Login;
import com.mindtree.entity.OTP;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorAddress;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationSignupControllerTest {

	@Autowired
	private SignupController signupController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(signupController).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void registerCustomerTest() throws Exception {
		
		assertThat(this.restTemplate.postForObject("http://localhost:" +port+ "/signup/customer", getFirstCustomerDto(), SignupResponseDTO.class))
		.isEqualToIgnoringGivenFields(getFirstResponse(), "otp", "status", "message");

		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/signup/customer", getSecondCustomerDto(),
				SignupResponseDTO.class)).isEqualToComparingOnlyGivenFields(getSecondResponse(), "email");
		
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/signup/customer", getThirdCustomerDto(),
				SignupResponseDTO.class)).isEqualToComparingOnlyGivenFields(getThirdResponse(), "email");

	}

	@Test
	public void registerVendorTest() throws Exception {

		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/signup/vendor", getVendorDto(), SignupResponseDTO.class))
		.isEqualToComparingOnlyGivenFields(getVendorResponse(), "email");
		
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/signup/vendor", getVendorDto(), SignupResponseDTO.class))
		.isEqualToComparingOnlyGivenFields(getVendorResponse(), "email");
	}
	
	@Test
	public void verifyOtpTest() throws Exception {
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/signup/verify", getOtp(), SignupResponseDTO.class))
		.isEqualToComparingOnlyGivenFields(getOtpResponse(), "email");
	}
	
	public Customer getFirstCustomer() {
		Customer customer = new Customer();
		CustomerAddress customerAddress = new CustomerAddress();

		customer.setEmailId("prakarshsurya@gmail.com");
		customer.setCustomerId("cust1001");
		customerAddress.setPhoneNumber("9896738956");
		
		customerAddress.setCustomer(customer);
		customer.setCustomerAddress(customerAddress);
		
		return customer;
	}

	public CustomerSignupDTO getFirstCustomerDto() {
		CustomerSignupDTO customerSignupDto = new CustomerSignupDTO();
		customerSignupDto.setCustomer(getFirstCustomer());
		customerSignupDto.setCustomerAddress(getFirstCustomer().getCustomerAddress());
		customerSignupDto.setLogin(getFirstLogin());
		
		return customerSignupDto;
	}

	public Login getFirstLogin() {
		Login login = new Login();
		login.setEmailId("prakarshsurya@gmail.com");
		login.setRole("customer");
		login.setPassword("mindtree@12");
		login.setStatus("not verified");
		return login;
	}
	
	public Customer getSecondCustomer() {
		Customer customer = new Customer();
		CustomerAddress customerAddress = new CustomerAddress();

		customer.setEmailId("prakarshsurya1@gmail.com");
		customer.setCustomerId("cust1002");
		
		customerAddress.setCustomer(customer);
		customerAddress.setPhoneNumber("7896738956");
		customer.setCustomerAddress(customerAddress);
		
		return customer;
	}
	
	public CustomerSignupDTO getSecondCustomerDto() {
		CustomerSignupDTO customerSignupDto = new CustomerSignupDTO();
		customerSignupDto.setCustomer(getSecondCustomer());
		customerSignupDto.setCustomerAddress(getSecondCustomer().getCustomerAddress());
		customerSignupDto.setLogin(getSecondLogin());
		
		return customerSignupDto;
	}

	public Login getSecondLogin() {
		Login login = new Login();
		login.setEmailId("prakarshsurya1@gmail.com");
		login.setPassword("mindtree@12");
		login.setRole("customer");
		login.setStatus("verified");
		return login;
	}

	public Customer getThirdCustomer() {
		Customer customer = new Customer();
		CustomerAddress customerAddress = new CustomerAddress();

		customer.setEmailId("prakarshsurya1@gmail.com");
		customer.setCustomerId("cust1003");
		
		customerAddress.setPhoneNumber("7896732956");
		customerAddress.setCustomer(customer);
		customer.setCustomerAddress(customerAddress);
		
		return customer;	}
	
	public CustomerSignupDTO getThirdCustomerDto() {
		CustomerSignupDTO customerSignupDto = new CustomerSignupDTO();
		customerSignupDto.setCustomer(getThirdCustomer());
		customerSignupDto.setCustomerAddress(getThirdCustomer().getCustomerAddress());
		customerSignupDto.setLogin(getThirdLogin());
		
		return customerSignupDto;
	}

	public Login getThirdLogin() {
		Login login = new Login();
		login.setEmailId("prakarshsurya1@gmail.com");
		login.setPassword("mindtree@12");
		login.setRole("customer");
		login.setStatus("verified");
		return login;
	}
	
	public SignupResponseDTO getFirstResponse() {
		SignupResponseDTO response = new SignupResponseDTO();
		response.setEmail("prakarshsurya@gmail.com");
		return response;
	}
	
	public SignupResponseDTO getSecondResponse() {
		SignupResponseDTO response = new SignupResponseDTO();
		response.setEmail("prakarshsurya1@gmail.com");
		return response;
	}
	
	public SignupResponseDTO getThirdResponse() {
		SignupResponseDTO response = new SignupResponseDTO();
		response.setEmail("prakarshsurya1@gmail.com");
		return response;
	}
	
	public VendorSignupDTO getVendorDto() {

		VendorSignupDTO vendorDto = new VendorSignupDTO();

		Vendor vendor = new Vendor();
		VendorAddress vendorAddress = new VendorAddress();
		Login login = new Login();

		vendor.setEmailId("nanirohith07@gmail.com");

		vendorAddress.setVendor(vendor);
		vendor.setVendorAddress(vendorAddress);

		login.setEmailId("nanirohith07@gmail.com");
		login.setRole("vendor");
		login.setPassword("mindtree@12");
		login.setStatus("verified");

		vendorDto.setLogin(login);
		vendorDto.setVendor(vendor);
		vendorDto.setVendorAddress(vendorAddress);
		return vendorDto;
	}

	

	public SignupResponseDTO getVendorResponse() {
		SignupResponseDTO response = new SignupResponseDTO();
		response.setEmail("nanirohith07@gmail.com");
		return response;
	}

	public OTP getOtp() {
		OTP otp = new OTP();
		otp.setEmailId("prakarshsurya@gmail.com");
		otp.setOtp("123455");
		return otp;
	}
	
	public Object getOtpResponse() {
		SignupResponseDTO otpResponse = new SignupResponseDTO();
		otpResponse.setEmail("prakarshsurya@gmail.com");
		return otpResponse;
	}


}
