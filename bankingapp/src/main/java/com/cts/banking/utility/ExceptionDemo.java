package com.cts.banking.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cts.banking.models.Individual;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scanner =new Scanner(System.in);
		int size=0;
		Individual[] individuals;
		try {
		System.out.println("Enter no of size");
		size=scanner.nextInt();
		System.out.println("Rows="+size);
		individuals=new Individual[-size];
		//System.out.println(individuals[]);		
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
		catch(InputMismatchException ex) {
			System.out.println(ex.getMessage());
		}
		catch(NegativeArraySizeException ex) {
			
			StackTraceElement[] stackTraceElements=ex.getStackTrace();
			for(StackTraceElement stackTraceElement: stackTraceElements) {
				System.out.println(stackTraceElement.getLineNumber());
				System.out.println(stackTraceElement.getMethodName());
				System.out.println(stackTraceElement.getClassName());
				System.out.println(stackTraceElement.getFileName());
			}
			
			
		}
		
		
		
		

	}

}
