package com.cts.gooddayproduct.gooddayapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.gooddayproduct.gooddayapp.models.Product;

@Controller
public class ProductController {
	//url handler
	@GetMapping("/home")
	public String loadHome(Model model) {
		//view page return by thymeleaf theme resolver
		model.addAttribute("product", new Product());
		return "home.html";
		
	}
	

}
