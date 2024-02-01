package com.cts.banking.utility;

import java.time.LocalDate;
import java.util.Random;

import com.cts.banking.exceptions.InvalidAgeException;
import com.cts.banking.models.Address;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;

public class IndividualApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Individual individual1;
      
      try {
      individual1=new Individual(
    		  1,
				new FullName("Customer","",""),
				"user@gmail.com",99520+new Random().nextInt(1000000),
			    new Address("16","First St","Chennai",602024L),
			    "Test@123", null,Gender.FEMALE,LocalDate.of(2021, 12, 2));
      }
      catch(InvalidAgeException ex) {
    	  System.out.println(ex.getMessage());
      }
      
      
      
      
		/*
		 * Individual individual2=new Individual( 2, new FullName("Customer","",""),
		 * "user@gmail.com",99520+new Random().nextInt(1000000), new
		 * Address("16","First St","Chennai",602024L), "Test@123",
		 * null,Gender.FEMALE,LocalDate.of(1970, 12, 2));
		 * 
		 * Individual individual3=individual2;
		 * System.out.println(individual1.equals(individual2));
		 */
		
		
		
		
		
	}

}
