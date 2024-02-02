package com.cts.banking.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor

public  class Customer{
//implements Comparable<Customer>{
	protected long accountNo;
	protected FullName name;
	@Setter
	protected String email;
	@Setter
	protected long contactNo;
	protected Address address;
	protected String password;
	//has relationship
	protected List<Account> accountList;
	
	//public abstract Customer getCustomer();
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return new Individual();
	}

}
