package com.cts.banking.models;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Individual extends Customer{
	
	private Gender gender;
	private LocalDate dob;
	public Individual(long accountNo, FullName name, String email, long contactNo, Address address, String password,
			List<Account> accountList, Gender gender, LocalDate dob) {
		super(accountNo, name, email, contactNo, address, password, accountList);
		this.gender = gender;
		this.dob = dob;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.accountNo+","+this.contactNo+","+this.name.getFirstName()+","+this.gender+
				this.dob;
	}
	
	
	
	
	
	
	

}
