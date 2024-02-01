package com.cts.banking.utility;

public class App {
	
	
	private static String convertToProperCase(String text) {		
		String[] data=text.split(" ");
		String result="";
		for(String txt : data) {
			result=result+Character.toUpperCase(txt.charAt(0))+txt.substring(1)+" ";			
		}
		return result;
	}
	

	//private int age;
	public static void main(String[] args) {
		
		System.out.println(convertToProperCase("Test the program"));
		
		
		// TODO Auto-generated method stub
       //octal representation  
	   byte data=0156;
	   System.out.println("Data="+data);
	   
	   //hexa representation
	   short amount=0x255;
	   System.out.println("Amount="+amount);
	   
	   //System.out.println(age);
	   
	   //constant array
	   
	   //final int[] shares= {56,78,90,83};
	  
	   
	   
	   
			   
	   
	}

}
