package com.waracle.cakemgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.repositories.CakeRepository;

@Service
public class CakeServiceImpl implements CakeService {

	@Autowired
	private CakeRepository cakeRepository;

	@Override
	public List<Cake> getAllAvailableCakes() {
		return cakeRepository.findAll();
	}

	@Override
	public Cake createCake(Cake cake) {
		return cakeRepository.save(cake);
	}

	@Override
	public void updateCakeQuantity(int quantity, String name) {
		Cake cake = getCakeByName(name);
		int updateQuantity = cake.getQuantity()+quantity;
	    cakeRepository.updateCakeQuantity(updateQuantity, name);
	}

	@Override
	public Cake getCakeByName(String name) {
		return cakeRepository.getCakeByName(name);
	}

}
