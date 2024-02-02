package com.cts.banking.utility;

import com.cts.banking.dao.CustomerDaoImpl;
import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.FullName;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.cts.banking.dao.CustomerDAO;
public class CustomerDaoApp {
	private static long seqNo;	
	private static long genAccountNo() {
		return ++seqNo;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO customerDao=new CustomerDaoImpl();	   
	   	    
	    //add values to the array	    
	    for(int i=0;i<100;i++) {
	    	customerDao.create(new Customer(genAccountNo(),
					new FullName("Customer","",String.valueOf(i)),
					"user"+i+"@gmail.com",99520+new Random().nextInt(1000000),
				    new Address("16","First St","Chennai",602024L),
				    "Test@123", null));
	    	
	    }
	    
	    
	    //display the values
	    Iterator<Customer> itr=customerDao.getAllCustomers().iterator();
	    
	    while(itr.hasNext()) {
	    	
	    	System.out.println(itr.next());
	    }
	    System.out.println(customerDao.update(1, "param@gmail.com", 9952032862L));
	    System.out.println(customerDao.delete(1));
	    
	}

}
