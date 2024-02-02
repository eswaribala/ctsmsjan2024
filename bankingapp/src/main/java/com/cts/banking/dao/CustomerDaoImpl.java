package com.cts.banking.dao;

import java.util.ArrayList;
import java.util.List;

import com.cts.banking.models.Customer;

public class CustomerDaoImpl implements CustomerDAO {
	
	private List<Customer> customers;
	
	public CustomerDaoImpl() {
		customers=new ArrayList<>();
	}
	

	@Override
	public Customer create(Customer customer) {
		// TODO Auto-generated method stub
		customers.add(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer update(long accountNo, String email, long contactNo) {
		Customer customerIdentified=null;
		// TODO Auto-generated method stub
		for(Customer customer : customers) {
			if(customer.getAccountNo()==accountNo) {				
				customer.setEmail(email);
				customer.setContactNo(contactNo);
				customerIdentified=customer;
			}
		}
		return customerIdentified;
	}

	@Override
	public boolean delete(long accountNo) {
		boolean status=false;
		Customer customerToBeDeleted=null;
		// TODO Auto-generated method stub
		for(Customer customer : customers) {
			if(customer.getAccountNo()==accountNo) {				
				customerToBeDeleted=customer;				
			}
		}
		
		customers.remove(customerToBeDeleted);
		status=true;
		return status;
	}

	
}
