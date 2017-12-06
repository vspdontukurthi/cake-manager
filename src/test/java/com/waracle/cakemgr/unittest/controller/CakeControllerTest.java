package com.waracle.cakemgr.unittest.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import com.waracle.cakemgr.controller.CakeController;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import com.waracle.cakemgr.test.utils.TestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes ={TestApplication.class})
public class CakeControllerTest {
	
	@LocalServerPort
	int port;

	@InjectMocks
	private CakeController cakeController;

	@Mock
	private CakeService cakeServiceMock;


	@Before
	public void setup() {
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGetCakeListViewWhenCalled() {
		when(cakeServiceMock.getAllAvailableCakes()).thenReturn(populateCakes());
		ModelMap modelMap = new ModelMap();
		String listOfCakesView = cakeController.getCakes(modelMap);
		assertEquals("cakes",listOfCakesView);
	}
	
	@Test
	public void shouldCreateCakeViewWhenCalled() {
		ModelMap modelMap = new ModelMap();
		String createCakeView = cakeController.createCakeView(modelMap);
		assertEquals("create_cake",createCakeView);
	}
	
	@Test
	public void shouldCreateCakeForwardToGetListViewWhenCalled() {
		when(cakeServiceMock.getCakeByName(any(String.class))).thenReturn(populateCake());
		when(cakeServiceMock.createCake(any(Cake.class))).thenReturn(populateCake());
		String createCakeView = cakeController.createCake(populateCake());
		assertEquals("redirect:/",createCakeView);
	}


	private List<Cake> populateCakes() {
		List<Cake> cakes = new ArrayList<>();
		cakes.add(populateCake());
		return cakes;
	}

	private Cake populateCake() {
		Cake cake = new Cake();
		cake.setName("tes1 cake1");
		cake.setPrice(2.50);
		cake.setQuantity(10);
		return cake;
	}

}
