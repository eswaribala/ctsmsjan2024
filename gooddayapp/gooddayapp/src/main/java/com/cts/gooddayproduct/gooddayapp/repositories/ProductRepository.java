package com.cts.gooddayproduct.gooddayapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.gooddayproduct.gooddayapp.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
