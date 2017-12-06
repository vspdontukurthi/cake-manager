package com.waracle.cakemgr.unittest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waracle.cakemgr.enums.CakeType;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import com.waracle.cakemgr.test.utils.TestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TestApplication.class })
public class CakeServiceTest {
	
	@Autowired
	private CakeService cakeService;
	
	@Test
	public void shouldCreateCakeWhenCalled() {
		Cake cake = new Cake();
		cake.setName(CakeType.AngelCake.name());
		cake.setPrice(2.50);
		cake.setQuantity(10);;
		Cake createdCake = cakeService.createCake(cake);
		assertNotNull(createdCake);
		assertNotNull(createdCake.getId());
	}
	
	@Test
	public void shouldUpdateQuantityWhenAddedExistingCake() {
		cakeService.updateCakeQuantity(10, "test cake1");
	    Cake updateCake = cakeService.getCakeByName( "test cake1");
		assertEquals(20, updateCake.getQuantity());
	}
	
	@Test
	public void shouldGetAllCAkesWhenCalled() {
		List<Cake> cakes = cakeService.getAllAvailableCakes();
		assertNotNull(cakes);
	}

}
