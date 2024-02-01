package com.cts.banking.utility;

import com.cts.banking.models.Customer;

public class OrderOfInvocation {
	Customer customer=new Customer();

	{
		System.out.println("Instance Block....");
	}
	
	static {
		System.out.println("Static Block.....");
	}
	
	public OrderOfInvocation() {
		
		System.out.println("Inside Order Constructor...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Main....");
		new OrderOfInvocation();
		new OrderOfInvocation();
	}

}
