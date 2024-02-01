package com.cts.banking.utility;

import java.util.Random;

import com.cts.banking.models.Employee;

public class VarArgsDemo {

	private static String genQualification(String... qualifications) {
		String result="";
		for(String qualification: qualifications) {
			result+=qualification+".,";
		}
		return result;
	}
	
	public static void main(String... args) {
		// TODO Auto-generated method stub
		
		Employee employee1 =new Employee(new Random().nextInt(100000),
				genQualification("B.E"));
		Employee employee2 =new Employee(new Random().nextInt(100000),
				genQualification("B.E","M.E"));
		Employee employee3 =new Employee(new Random().nextInt(100000),
				genQualification("B.E","M.E","Ph.D"));
		Employee employee4 =new Employee(new Random().nextInt(100000),
				genQualification());	
		
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		System.out.println(employee4);

	}

}
