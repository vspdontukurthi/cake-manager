package com.waracle.cakemgr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;

@Controller
public class CakeController {
	
	@Autowired
	private CakeService cakeService;
	
	
	@GetMapping("/")
	public String getCakes(ModelMap model) {
		List<Cake> listOfCakes = new ArrayList<Cake>();
		listOfCakes = cakeService.getAllAvailableCakes();
		model.addAttribute("cakes", listOfCakes);
		return "cakes";
	}
	
	@GetMapping("/cake")
	public String createCakeView(ModelMap model) {
		model.addAttribute("cake", new Cake());
		return "create_cake";
	}
	
	@PostMapping("/cake")
	public String createCake(Cake cake) {
		Cake getCake = cakeService.getCakeByName(cake.getName());
		if(getCake!=null) {
			cakeService.updateCakeQuantity(cake.getQuantity(), cake.getName());
		} else {
			cakeService.createCake(cake);
		}
		return "redirect:/";
	}


}
