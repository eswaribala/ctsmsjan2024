package com.cts.gooddayproduct.gooddayapp.services;

import java.util.List;

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

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product updateProduct(int itemCode, int unitPrice) {		
		Product product=this.productRepository.findById(itemCode).orElse(null);
		if(product!=null) {
			product.setUnitPrice(unitPrice);
			this.productRepository.save(product);
			return product;
		}
		else
		{
			return null;
		}			
		
	}
	
    public boolean deleteProduct(int itemCode) {
		boolean status=false;
		Product product=this.productRepository.findById(itemCode).orElse(null);
		if(product!=null) {			
			this.productRepository.delete(product);
			status=true;
		}			
		return status;		
	}
	
}
