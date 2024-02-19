package com.cts.banking.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.banking.models.Address;
import com.cts.banking.models.Corporate;
import com.cts.banking.models.CreditCard;
import com.cts.banking.models.Customer;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;

public class App {

	public static void main(String[] args) {
		//ApplicationContext applicationContext=new 
			//	ClassPathXmlApplicationContext("banking-config.xml");
		
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext();
		applicationContext.register(Customer.class);
		applicationContext.refresh();		
		
		Customer customer=(Customer) applicationContext.getBean("customer");
		customer.setAccountNo(new Random().nextInt(10000));
		customer.setContactNo(9952032862L);
		customer.setEmail("Param@gmail.com");
		customer.setPassword("Test@123");
		FullName fullName=customer.getName();
		fullName.setFirstName("Parameswari");
		fullName.setLastName("Bala");
		customer.setName(fullName);
		List<Address>addresses=customer.getAddresses();
		Address address=addresses.get(0);
		address.setDoorNo("16");
		address.setCity("Chennai");
        address.setPincode(602024);
        address.setStreetName("First Street");
        
        
		CreditCard creditCard=customer.createCreditCard();
		creditCard.setCardNo(238758735);
        creditCard.setExpiryDate(LocalDate.now().plusYears(10));
        creditCard.setLimit(100000);		
		System.out.println(customer.getName().getFirstName());
		customer.getAddresses().stream().forEach(System.out::println);		
		System.out.println(creditCard);
		/*
		Individual individual=(Individual) applicationContext.getBean("individual");
		individual.setGender(Gender.FEMALE);
		System.out.println(individual);
		Corporate corporate=(Corporate) applicationContext.getBean("corporate");
		System.out.println(corporate);
		*/
	}

}
