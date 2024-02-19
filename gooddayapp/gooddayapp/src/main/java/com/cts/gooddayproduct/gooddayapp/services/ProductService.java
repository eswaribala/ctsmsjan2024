package com.cts.gooddayproduct.gooddayapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.gooddayproduct.gooddayapp.models.Product;
import com.cts.gooddayproduct.gooddayapp.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProducts(Product product) {
		
		if(product.getItemName().length()>0) {
			return this.productRepository.save(product);
		}
		else
			return null;
		
	}

}
