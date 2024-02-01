package com.cts.banking.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Customer{
//implements Comparable<Customer>{
	private long accountNo;
	private FullName name;
	@Setter
	private String email;
	@Setter
	private long contactNo;
	private Address address;
	private String password;
	//has relationship
	private List<Account> accountList;
	
	

}
