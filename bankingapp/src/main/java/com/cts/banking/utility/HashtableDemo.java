package com.cts.banking.utility;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.cts.banking.models.Address;
import com.cts.banking.models.Customer;
import com.cts.banking.models.FullName;
import com.cts.banking.models.Transaction;
import com.cts.banking.facades.TransactionSorter;

public class HashtableDemo {
	private static int id;
	private static int customerId;
	
	private static int getSeqNo() {
		return ++id;
	}
	private static int getCustomerSeqNo() {
		return ++customerId;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Hashtable<Transaction,Customer> transactions=
				//new Hashtable<Transaction,Customer>();
		
		TreeMap<Transaction,Customer> transactions=
				new TreeMap<Transaction,Customer>(new TransactionSorter());
		Customer customer=null;
		int count=0;
		int sum=0;
		Transaction transaction=null;
		for(int i=0;i<5;i++) {
			count=0;
			sum=0;
			customer=new Customer(getCustomerSeqNo(),
					new FullName("Customer","",String.valueOf(i)),
					"user"+i+"@gmail.com",99520+new Random().nextInt(1000000),
				    new Address("16","First St","Chennai",602024L),
				    "Test@123",null);
			for(int j=0;j<(1+new Random().nextInt(5));j++) {
				transaction=new Transaction(getSeqNo(),
						LocalDateTime.now(),new Random().nextInt(10000),
						"Sender"+j,"Receiver"+j,null);
				
				transactions.put(transaction,customer);
				count+=1;
				sum+=transaction.getAmount();		
			}	
			
			System.out.println("AccountNo="+customer.getAccountNo()+","+count+","+sum);
			
		}
		
		//display
		
		Set<Map.Entry<Transaction, Customer>> mapEntry= transactions.entrySet();
		
		Iterator<Map.Entry<Transaction, Customer>> itr=mapEntry.iterator();
		
		Map.Entry<Transaction,Customer> entry=null;
		
		
		while(itr.hasNext()) {
			entry=itr.next();
			System.out.println(entry.getKey()+","+entry.getValue());
			
		}
		
	
		
		

	}

}
