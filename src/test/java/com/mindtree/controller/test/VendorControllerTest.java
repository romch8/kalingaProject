
package com.mindtree.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.controller.VendorController;
import com.mindtree.entity.Vendor;
import com.mindtree.entity.VendorAddress;
import com.mindtree.repository.VendorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VendorControllerTest {
	@Autowired
	private VendorController vendorController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(vendorController).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Bean
	public CommandLineRunner setup(VendorRepository vendorRepository) {
		return (args) -> {
			vendorRepository.save(getvendorDummyData());
		};
	}
	public Map<String, String> getUrlVariables() {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("vendorId", "vend1");
		return urlVariables;
	}

	public Vendor getvendorDummyData() {
		Vendor detail = new Vendor();
		VendorAddress vendorAddress = new VendorAddress();
		detail.setVendorId("vend1");
		detail.setEmailId("prakarshsurya2@gmail.com");
		detail.setRegistrationId("100");
		detail.setName("surya");
		vendorAddress.setId(1);
		vendorAddress.setPhoneNumber("8344939050");
		detail.setVendorAddress(vendorAddress);
		return detail;

	}

}
