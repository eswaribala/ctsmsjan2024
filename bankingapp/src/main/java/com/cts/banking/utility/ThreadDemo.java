package com.cts.banking.utility;

import java.util.Scanner;

import com.cts.banking.models.DirectDebitTransaction;
import com.cts.banking.threads.Clock;
import com.cts.banking.threads.SimpleThread;

public class ThreadDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * SimpleThread simpleThread=new SimpleThread("Parameswari");
		 * simpleThread.start(); Scanner scanner=new Scanner(System.in);
		 * System.out.println("Enter Answer"); String answer=scanner.nextLine();
		 * if(answer!=null) simpleThread.interrupt();
		 */
		
		
		//System.out.println(simpleThread.isAlive());
		//simpleThread.start();
		//multi threaded environment
		/*
		 * Thread[] threads=new Thread[4]; for(int i=0;i<threads.length;i++) {
		 * threads[i]=new Thread(new DirectDebitTransaction(),"Direct-Debit-Thread-"+i);
		 * threads[i].start(); }
		 */
		
		
		//join
		
		System.out.println("Main Started the Task......");
		
		Clock clock=new Clock();
		clock.start();
		try {
			clock.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Completed the Task......");
		
		
		
	}

}
