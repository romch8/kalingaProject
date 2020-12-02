package com.mindtree.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.controller.CustomerController;
import com.mindtree.dto.CustomerSignupDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.CustomerAddress;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
	@Autowired
	private CustomerController customerController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(customerController).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCustomerDetailsByIdTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/customer/{customerId}", Customer.class,
				getUrlVariables())).isNotNull();

	}


	@Test
	public void updateCustomerTest() throws Exception {
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "customer/{customerId}",
				getCustomer(), CustomerSignupDTO.class, getUrlVariables())).isNotNull();
	}

	public Map<String, String> getUrlVariables() {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("customerId", "cust1001");
		return urlVariables;
	}

	public CustomerSignupDTO getCustomer() {
		CustomerSignupDTO customerDto = new CustomerSignupDTO();

		Customer customer = new Customer();
		CustomerAddress customerAddress = new CustomerAddress();
		customer.setCustomerId("cust1005");
		customer.setCustomerIdProof("QWE098TYU098");
		customer.setCustomerIdProofType("Pan card");
		customer.setEmailId("mownika@gmail.com");
		customer.setFirstName("mownika");
		
		customer.setLastName("nagu");
		customer.setPreferredCategory("veg");
		customer.setPreferredCuisine("Vegan indian");

		customerAddress.setCity("canada");
		customerAddress.setDistanceFromNearestLocation("2km");
		customerAddress.setLandlineNumber("04425986415");
		customerAddress.setNearestLocation("theatre");
		customerAddress.setPhoneNumber("9908788456");
		customerAddress.setPincode("600123");
		customerAddress.setState("Sri Lanka");
		customerAddress.setStreet("Mint Street");

		customerDto.setCustomer(customer);
		customerDto.setCustomerAddress(customerAddress);

		return customerDto;
	}

}