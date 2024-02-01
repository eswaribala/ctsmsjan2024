package com.cts.banking.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.cts.banking.exceptions.InvalidAgeException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

//@AllArgsConstructor
@NoArgsConstructor

public class Individual extends Customer{
	
	private Gender gender;
	private LocalDate dob;
	public Individual(long accountNo, FullName name, String email, long contactNo, Address address, String password,
			List<Account> accountList, Gender gender, LocalDate dob) throws InvalidAgeException {
		super(accountNo, name, email, contactNo, address, password, accountList);
		this.gender = gender;
		
		if(ChronoUnit.YEARS.between(dob,LocalDate.now())>=18)
				this.dob = dob;
		else
			throw new InvalidAgeException("Age should be 18 or above");
	}
	@Override
	public String toString() {
	
		// TODO Auto-generated method stub
		return super.toString()+this.gender+this.dob;
	}
	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return new Individual();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Individual individual=(Individual) obj;
		return this.accountNo==individual.accountNo;
	}
	
	
		
	
	
	

}
