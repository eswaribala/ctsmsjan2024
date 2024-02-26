package com.cts.resilience4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CbService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${serviceUrl}") 
	private String serviceUrl;
	@Value("${alternativeServiceUrl}") 
	private String alternativeUrl;
	
	@CircuitBreaker(name="gatewayCircuitBreaker",fallbackMethod="invokeFallbackBankAPI" 
			)
	@Retry(name="gatewayRetry")
	public ResponseEntity<String> invokeBankAPI() {
		
		log.info("Retrying......");
		return restTemplate.exchange(serviceUrl, 
				HttpMethod.GET,null,String.class);
		
	}
	
	public ResponseEntity<String> invokeFallbackBankAPI(Exception e) {
		
		return restTemplate.exchange(alternativeUrl, 
				HttpMethod.GET,null,String.class);
		
	}
	

}
