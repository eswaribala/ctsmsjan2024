package com.cts.banking.utility;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.cts.banking.exceptions.InvalidAgeException;
import com.cts.banking.facades.DataSupplier;
import com.cts.banking.facades.OTPGenerator;
import com.cts.banking.facades.VerticalTextCreator;
import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.Employee;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //non parameterized lambda
		OTPGenerator otpGenerator=()-> new Random().nextInt(9999);
		System.out.println(otpGenerator.getOTP());
		//parameterized lambda
		VerticalTextCreator verticalTextCreator=(message)-> message.toCharArray();
		
		for(char c : verticalTextCreator.printVerticalText("Parameswari")) {
			System.out.println(c);
		}
		//inbuilt functional interface with lambda
		Runnable runnable= ()->System.out.println(Thread.currentThread().getName());
		runnable.run();
		//Function 		
		Function<Individual,Boolean> function=(individual)->{
			
			return individual.getDob().isAfter(LocalDate.now());
		};
		try {
		System.out.println(function.apply(new Individual(
						new Random().nextInt(1000000),
					new FullName("Customer","",""),
					"user@gmail.com",99520+new Random().nextInt(1000000),
				    new Address("16","First St","Chennai",602024L),
				    "Test@123", null,Gender.FEMALE,
				    LocalDate.of(1900+new Random().nextInt(100),
				    		1+new Random().nextInt(11), 1+new Random().nextInt(26)))));
		
		}
		catch(InvalidAgeException ex) {
			
		}
		
		//BiFunction
		BiFunction<LocalDate,LocalDate,Long> biFunction=
				(dob,currentDate)->ChronoUnit.YEARS.between(dob,currentDate);
		
	    System.out.println(biFunction.apply(LocalDate.of(1970, 12, 1), LocalDate.now()));
	    
	    
	    //Supplier
	    
	    Supplier<Integer> supplier=()->new Random().nextInt(9999);
	    System.out.println(supplier.get());
	    
	    
	    //Consumer
	    
	    Consumer<char[]> consumer=(message)->{
	    	for(char ch: message) {
	    		System.out.println(ch);
	    	}
	    };
		
		consumer.accept(("Cognizant Technologies").toCharArray());
		
		//Bipredicate
		BiPredicate<Employee,Employee> bipredicate=(emp1,emp2)-> emp1.equals(emp2);
		
		System.out.println(bipredicate.test(new Employee(1,null), new Employee(2,null)));
		
		
		//constructor reference		
		Supplier<Individual> supplierObj=Individual::new;
		System.out.println(supplierObj.get());
		
		//instance method reference
		Customer customer=new Customer(1,
				new FullName("Customer","",""),
				"user@gmail.com",99520+new Random().nextInt(1000000),
			    new Address("16","First St","Chennai",602024L),
			    "Test@123", null);
		
		 DataSupplier<FullName> fullName=customer::getName; 
		 System.out.println(fullName.getData().getFirstName()+","+
		 fullName.getData().getLastName());
		 
		 DataSupplier<Address> address=customer::getAddress;
		
		 System.out.println(address.getData().getCity()+","+
				 address.getData().getPincode());
		
		
		 //Static Method Reference
		 
		 DataSupplier<Integer> otp=DataSupplier::getOTP;
		 System.out.println(otp.getData());
		 
		 
		 //instance method reference
		 Consumer<Customer> customerInstance=System.out::println;
		 
		 customerInstance.accept(new Customer(1,
				new FullName("Customer","",""),
				"user@gmail.com",99520+new Random().nextInt(1000000),
			    new Address("16","First St","Chennai",602024L),
			    "Test@123", null));
		 
		 Function<String,Integer> funcInstance=Integer::parseInt;
		 System.out.println(funcInstance.apply("7635275"));
		
		
	}

}

