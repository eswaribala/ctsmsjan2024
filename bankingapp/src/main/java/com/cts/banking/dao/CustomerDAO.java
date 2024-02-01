package com.cts.banking.dao;

import java.util.List;

import com.cts.banking.models.Customer;

public interface CustomerDAO {
	
	Customer create(Customer customer);
	List<Customer> getAllCustomers();
	Customer update(long accountNo,String email, long contactNo);
	boolean delete (long accountNo);

}
