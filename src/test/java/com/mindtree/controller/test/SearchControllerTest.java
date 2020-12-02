package com.mindtree.controller.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.controller.SearchController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {

	@Autowired
	private SearchController searchController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(searchController).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void searchItems() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/search/items", String.class))
				.isNotNull();
	}

	@Test
	public void citiesTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/search/cities", String.class))
				.isNotNull();
	}

	public Map<String, String> getUrlVariables() {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("selectedItem", "chicken");
		urlVariables.put("selectedCity", "hyderabad");
		urlVariables.put("vendorid", "vend1001");
		return urlVariables;
	}

	public List<String> getItems() {
		List<String> list = new ArrayList<>();
		String s1 = "chicken";
		String s2 = "paneer";
		String s3 = "egg";
		list.add(s1);

		list.add(s2);
		list.add(s3);

		return list;

	}

	public List<String> getCities() {
		List<String> list2 = new ArrayList<>();
		String s1 = "hyderabd";
		String s2 = "banglore";
		String s3 = "Bhubaneswar";
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);

		return list2;

	}
	public List<String> getItemsResponse() {
		List<String> list = new ArrayList<>();
		String s3 = "chicken";
		String s4 = "paneer";
		String s5 = "egg";
		list.add(s3);
		list.add(s4);
		list.add(s5);
		return list;

	}

	public List<String> getCitiesResponse() {
		List<String> list = new ArrayList<>();
		String s4 = "hyderabad";
		String s6 = "banglore";
		String s7 = "Bhubaneswar";
		list.add(s4);
		list.add(s6);
		list.add(s7);

		return list;

	}
}
