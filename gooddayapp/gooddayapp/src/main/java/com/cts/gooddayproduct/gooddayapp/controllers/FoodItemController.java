package com.cts.gooddayproduct.gooddayapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gooddayproduct.gooddayapp.dtos.ResponseWrapper;
import com.cts.gooddayproduct.gooddayapp.models.FoodItem;
import com.cts.gooddayproduct.gooddayapp.models.Product;
import com.cts.gooddayproduct.gooddayapp.services.ProductService;

@RestController
@RequestMapping(value="/foodItems", produces = { "application/json", "application/xml"})
public class FoodItemController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> addFoodItem(@RequestBody FoodItem foodItem){
		
		Product product=this.productService.saveProducts(foodItem);
		if(product!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseWrapper<Product>(product));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseWrapper("Product Could not be added"));
		}
		
	}
	@GetMapping("/v1.0/")
	public List<Product> getAllProducts(){
		return this.productService.getAllProducts();
	}
	
	@PutMapping("/v1.0/{itemCode}/{unitPrice}")
	public ResponseEntity<ResponseWrapper> updateProduct(@PathVariable("itemCode") 
	int itemCode, @PathVariable("unitPrice") int unitPrice){
		Product product=this.productService.updateProduct(itemCode, unitPrice);
		if(product!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseWrapper<Product>(product));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseWrapper("Product Could not be updated"));
		}
	}
	
	@DeleteMapping("/v1.0/{itemCode}")
	public ResponseEntity<ResponseWrapper> deleteProduct(@PathVariable("itemCode") 
	int itemCode){
		boolean status=this.productService.deleteProduct(itemCode);
		if(status) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseWrapper("Product Deleted-->"+itemCode));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseWrapper("Product Could not be deleted...."+itemCode));
		}
	}
	
	

}
