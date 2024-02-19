package com.cts.banking.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@Import({FullName.class,Address.class})
public  class Customer{
//implements Comparable<Customer>{
	protected long accountNo;
	@Autowired
	protected FullName name;
	@Setter
	protected String email;
	@Setter
	protected long contactNo;	
	protected String password;	
	@Autowired
	protected List<Address> addresses;
	
	@Bean
	public CreditCard createCreditCard() {
		return new CreditCard();
	}

}
