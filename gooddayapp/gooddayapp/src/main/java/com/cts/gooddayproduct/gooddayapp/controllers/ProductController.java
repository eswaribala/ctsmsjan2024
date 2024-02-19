package com.cts.gooddayproduct.gooddayapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.gooddayproduct.gooddayapp.models.Product;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {
	//url handler
	@GetMapping("/home")
	public String loadHome(Model model) {
		//view page return by thymeleaf theme resolver
		model.addAttribute("product", new Product());
		return "home.html";
		
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		
		log.info(""+product.getItemCode());
		return "showProducts.html";
	}
	

}
