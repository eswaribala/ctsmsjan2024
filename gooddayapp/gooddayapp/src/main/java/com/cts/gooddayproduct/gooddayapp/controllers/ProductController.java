package com.cts.gooddayproduct.gooddayapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.gooddayproduct.gooddayapp.models.Product;
import com.cts.gooddayproduct.gooddayapp.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {
	@Autowired
	private ProductService productService;
	//url handler
	@GetMapping("/home")
	public String loadHome(Model model) {
		//view page return by thymeleaf theme resolver
		model.addAttribute("product", new Product());
		return "home.html";
		
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		
		log.info(""+product.getItemName());
		
		Product productResponse=productService.saveProducts(product);
		
		if(productResponse!=null) {
		  model.addAttribute("productResponse", productResponse);
		  return "showProduct.html";
		}
		else
			return "redirect:/home";
	}
	
	@GetMapping("/products")
	public String getAllProducts(Model model) {
		
		List<Product> products=productService.getAllProducts();
		
		if(products.size()>0) {
			model.addAttribute("products", products);
			return "
		}
		
		
	}
	

}
