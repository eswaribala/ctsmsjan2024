package com.cts.banking.utility;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cts.banking.dao.CustomerDAO;
import com.cts.banking.dao.CustomerDaoImpl;
import com.cts.banking.exceptions.InvalidAgeException;
import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.Developer;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;
import com.cts.banking.models.Project;
public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO customerDao=new CustomerDaoImpl();
		//add values to the array	    
	    for(int i=1;i<100;i++) {
	    	customerDao.create(new Customer(new Random().nextInt(500),
					new FullName("Customer","",String.valueOf(i)),
					"user"+i+"@gmail.com",99520+new Random().nextInt(1000000),
				    new Address("16","First St","Chennai",602024L),
				    "Test@123", null));	   	
	    }	    
	    //apply streaming
	    customerDao.getAllCustomers().stream()
	    .filter(c->c.getAccountNo()%2==1)
	    .sorted((c1,c2)->{
	       if(c1.getAccountNo()>c2.getAccountNo())
	    	   return 1;
	       else if(c1.getAccountNo()<c2.getAccountNo())
	    	   return -1;
	       else
	    	   return 0;
	    })
	   .map(c->c.getAccountNo()+","+c.getName().getFirstName())
	    
	    .limit(10)
	    .skip(3)
	    .forEach(System.out::println);
	    
	    
	  //individual dob sorting
	    List<Individual> individuals=new ArrayList<Individual>();
	    try {
			for(int i=0;i<100;i++) {
				
					individuals.add(new Individual(
							new Random().nextInt(1000000),
						new FullName("Customer","",""),
						"user@gmail.com",99520+new Random().nextInt(1000000),
					    new Address("16","First St","Chennai",602024L),
					    "Test@123", null,Gender.FEMALE,
					    LocalDate.of(1900+new Random().nextInt(100),
					    		1+new Random().nextInt(11), 1+new Random().nextInt(26))));			
			}
			
			} catch (InvalidAgeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	    
	    individuals.stream().sorted((i1,i2)->i1.getDob().compareTo(i2.getDob()))
	    .map(i->i.getName().getFirstName()+","+i.getDob())
	    .skip(individuals.size()-10)
	    .forEach(System.out::println);
	    
	    //flatmap
	    
	    List<Developer> developers=new ArrayList<Developer>();
	    List<String> skills=new ArrayList();
	    skills.add("Java");
	    skills.add("C++");
	    skills.add("Dotnet");
	    skills.add("Golang");		
	    for(int i=0;i<5;i++) {	    	
	    	developers.add(new Developer(i,skills.subList(0,1+new Random().nextInt(4))));	    	
	    }
	    
	    List<Project> projects=new ArrayList<Project>();
	    for(int i=0;i<10;i++) {
	    	projects.add(new Project(i,developers.subList(0, 1+new Random().nextInt(5))));
	    }
	    
	    
	    
		
		
	}

}
