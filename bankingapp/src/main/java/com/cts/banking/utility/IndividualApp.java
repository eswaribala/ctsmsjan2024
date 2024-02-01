package com.cts.banking.utility;

import java.time.LocalDate;
import java.util.Random;

import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;

public class IndividualApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Individual individual=new Individual(
				1L,
				new FullName("Customer","",""),
				"user@gmail.com",99520+new Random().nextInt(1000000),
			    new Address("16","First St","Chennai",602024L),
			    "Test@123", null,Gender.FEMALE,LocalDate.of(1970, 12, 2));
		
		System.out.println(individual);
		
		
		
		
		
	}

}
