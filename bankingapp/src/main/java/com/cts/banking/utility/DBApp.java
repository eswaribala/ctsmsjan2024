package com.cts.banking.utility;

import java.util.regex.Pattern;

public class DBApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pattern="^[A-Za-z]*$";
		
		if(args.length>=1) {
			 
		  if(Pattern.matches(pattern, args[0])) {
			  System.out.println("Name is only in alphabets");
			  
		  }
			
		}

	}

}
