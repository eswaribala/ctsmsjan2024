package com.cts.banking.utility;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.cts.banking.facades.CustomerSorter;
import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.FullName;

public class BankingApplication {

	private static long seqNo;	
	private static long genAccountNo() {
		return ++seqNo;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
	    System.out.println("Enter no of customers");
	    Scanner scanner=new Scanner(System.in);	    
	    int customerCount=scanner.nextInt();	    
	    //create array of customers
	    Customer[] customers=new Customer[customerCount];	    
	    //add values to the array	    
	    for(int i=0;i<customerCount;i++) {
	    	customers[i]=new Customer(genAccountNo(),
					new FullName("Customer","",String.valueOf(i)),
					"user"+i+"@gmail.com",99520+new Random().nextInt(1000000),
				    new Address("16","First St","Chennai",602024L),
				    "Test@123", null);
	    }
	
	    Arrays.sort(customers, new CustomerSorter());
	    //show customer details
	    
	    for(Customer customer: customers) {
	    	System.out.println(customer.getAccountNo()
	    			+","+customer.getName().getFirstName()+"-"+customer.getName().getLastName());
	    }
		*/
		
	}

}
