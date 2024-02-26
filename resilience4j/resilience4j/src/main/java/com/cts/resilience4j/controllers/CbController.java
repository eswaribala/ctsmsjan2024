package com.cts.resilience4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.resilience4j.services.CbService;

@RestController
@RequestMapping("/cb")
public class CbController {
	@Autowired
	private CbService cbService;

	@GetMapping("/v1.0/")
	public ResponseEntity<String> getCustomers(){
		return cbService.invokeBankAPI();
	}
}
