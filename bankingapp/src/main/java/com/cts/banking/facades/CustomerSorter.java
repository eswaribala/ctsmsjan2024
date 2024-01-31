package com.cts.banking.facades;

import java.util.Comparator;

import com.cts.banking.models.Customer;

public class CustomerSorter implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		
		if(o1.getAccountNo()>o2.getAccountNo())
			return 1;
		else if(o1.getAccountNo()<o2.getAccountNo())
			return -1;
		else
			return 0;
	}

}
