package com.waracle.cakemgr.service;

import java.util.List;

import com.waracle.cakemgr.model.Cake;

public interface CakeService {
	
	public List<Cake> getAllAvailableCakes();
	
	public Cake createCake(Cake cake);
	
	public void updateCakeQuantity(int quantity, String name);
	
	public Cake getCakeByName(String name);
	

}
