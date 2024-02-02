package com.cts.banking.utility;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Random;

import com.cts.banking.models.Address;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Gender;
import com.cts.banking.models.Individual;
import com.cts.banking.exceptions.InvalidAgeException;
import com.cts.banking.facades.IndividualSorter;
public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Individual> priorityQueue=new PriorityQueue<Individual>
		   (new IndividualSorter());
		try {
		for(int i=0;i<100;i++) {
			
				priorityQueue.offer(new Individual(
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
		//display
		Individual individual=null;
		while(!priorityQueue.isEmpty()) {
			individual=priorityQueue.poll();
			System.out.println(individual);
			
		}
		
		
	}

}
