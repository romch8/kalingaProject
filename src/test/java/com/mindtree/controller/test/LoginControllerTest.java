package com.mindtree.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.controller.LoginController;
import com.mindtree.dto.ForgotDTO;
import com.mindtree.dto.ForgotResponseDTO;
import com.mindtree.dto.LoginDto;
import com.mindtree.entity.Login;
import com.mindtree.entity.OTP;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

	@Autowired
	private LoginController logincontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(logincontroller).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCustomerTest() throws Exception {

		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/customer/forgot", getCustomer(),
				ForgotResponseDTO.class)).isEqualToComparingOnlyGivenFields(getResponse(), "email");

	}

	@Test
	public void verifyOtpTest() throws Exception {
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/customer/verify", getOtp(),
				ForgotResponseDTO.class)).isEqualToComparingOnlyGivenFields(getOtpResponse(),"email");
	}

	private Object getOtpResponse() {
		ForgotResponseDTO otpResponse = new ForgotResponseDTO();
		otpResponse.setEmail("prakarshsurya2@gmail.com");
		return otpResponse;
	}

	public ForgotResponseDTO getResponse() {
		ForgotResponseDTO response = new ForgotResponseDTO();
		response.setStatus("success");
		response.setMessage("Successfully registered. Please check email for verifying account.");
		response.setEmail("prakarshsurya2@gmail.com");
		return response;
	}

	public ForgotDTO getCustomer() {
		ForgotDTO forgotDto = new ForgotDTO();
		forgotDto.setEmailId("prakarshsurya2@gmail.com");
		return forgotDto;
	}

	public OTP getOtp() {
		OTP otp = new OTP();
		otp.setEmailId("prakarshsurya2@gmail.com");
		otp.setOtp("123455");
		return otp;
	}

// 	@Test
// 	public void loginCustomerTest() throws Exception {
// 		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/customer/customerlogin",
// 				getcustomerloginDto(), Login.class)).isEqualToComparingOnlyGivenFields(getcustomerlogin(), "emailId");
// 	}

	public LoginDto getcustomerloginDto() {
		LoginDto dto = new LoginDto();
		dto.setEmailId("prakarshsurya1@gmail.com");
		dto.setPassword("mindtree@12");
		dto.setRole("customer");
		return dto;
	}

	public Login getcustomerlogin() {
		Login dto = new Login();
		dto.setEmailId("prakarshsurya1@gmail.com");
		return dto;
	}

	public LoginDto getvendorlogin() {
		LoginDto dto = new LoginDto();
		Login login = new Login();

		login.setEmailId("nanirohith07@gmail.com");
		login.setPassword("mindtree@12");
		login.setRole("vendor");

		return dto;
	}

}
