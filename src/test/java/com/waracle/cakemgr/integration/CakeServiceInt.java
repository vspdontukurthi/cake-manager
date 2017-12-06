package com.waracle.cakemgr.integration;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.repositories.CakeRepository;
import com.waracle.cakemgr.test.utils.TestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TestApplication.class })
@Category(IntegrationTest.class)
public class CakeServiceInt {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private CakeRepository  cakeRepository;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void setup() {
		cakeRepository.save(populateCake());
	}
	
	@Test
	public void shouldGetAllCakesWhenCalled() {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/"),
				HttpMethod.GET, entity, String.class);
		String responseBody = response.getBody();
		
		assertNotNull(responseBody);
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	private Cake populateCake() {
		Cake cake = new Cake();
		cake.setName("inttest cake1");
		cake.setPrice(2.50);
		cake.setQuantity(10);
		return cake;
	}

}
