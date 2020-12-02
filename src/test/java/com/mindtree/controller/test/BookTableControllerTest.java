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

import com.mindtree.controller.BookTableController;
import com.mindtree.entity.Bookings;
import com.mindtree.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookTableControllerTest {
	@Autowired
	private BookTableController booktablecontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(booktablecontroller).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void bookTableTest() throws Exception {
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/table/postbooking/{customerId}",
				getBook(), Bookings.class, getUrlVariables())).isNotNull();
	}

	public Map<String, String> getUrlVariables() {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("customerId", "vend1");
		return urlVariables;
	}

	public Bookings getBook() {
		Bookings book = new Bookings();
		Customer customer = new Customer();
		customer.setCustomerId("cust1004");
		book.setBookingStatus("booked");
		book.setCustomer(customer);
		return book;
	}
}
