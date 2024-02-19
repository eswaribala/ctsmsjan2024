package com.cts.banking.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
	protected String password;	
	protected List<Address> addresses;

}
