package com.cts.bankingretailapi.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bankingretailapi.dtos.ResponseWrapper;
import com.cts.bankingretailapi.models.Account;
import com.cts.bankingretailapi.services.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;	
	@PostMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> addAccount(@RequestBody Account account){
		
		Account accountObj=this.accountService.addAccount(account);
		if(account!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseWrapper<Account>(accountObj));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseWrapper("Account Could not be added"));
		}
		
	}
	@GetMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.GET)
	public List<Account> getAllAccounts(){
		return this.accountService.getAccounts();
	}
	@GetMapping("/v1.0/{dop}")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.GET)
	public List<Account> getAllAccountsByDOP(@PathVariable("dop") 
	LocalDate dop){
		return this.accountService.getAccountsByDop(dop);
	
	}
}
