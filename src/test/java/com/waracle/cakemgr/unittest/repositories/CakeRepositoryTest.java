package com.waracle.cakemgr.unittest.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.repositories.CakeRepository;
import com.waracle.cakemgr.test.utils.TestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {TestApplication.class})
public class CakeRepositoryTest {
	
	@Autowired
	private CakeRepository cakeRepository;
	
	@Test
	public void shouldGetAllCakes() {
		List<Cake> cakes = cakeRepository.findAll();
		assertNotNull(cakes);
	}
	
	@Test
	public void shouldGetCakeByNameWhenCalled() {
		Cake cake = cakeRepository.getCakeByName("test cake1");
		assertEquals(23, cake.getId());
	}
	
}
