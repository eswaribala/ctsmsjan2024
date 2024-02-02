package com.cts.banking.utility;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.cts.banking.models.Employee;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Employee> javaTrained=new HashSet<Employee>();
		HashSet<Employee> dotnetTrained=new HashSet<Employee>();
		HashSet<Employee> copyJavaTrained=javaTrained;
		HashSet<Employee> copyDotnetTrained=dotnetTrained;
		
		for(int i=0;i<5;i++) {
			javaTrained.add(new Employee(i,null));
		}
		for(int i=3;i<10;i++) {
			dotnetTrained.add(new Employee(i,null));
		}
		
		copyJavaTrained.removeAll(copyDotnetTrained);
		
		System.out.println("Remove");
		
		for(Employee employee:copyJavaTrained) {
			System.out.println(employee);
		}
		
		javaTrained.addAll(dotnetTrained);
		System.out.println("Union");
		for(Employee employee:javaTrained) {
			System.out.println(employee);
		}
		
		System.out.println("Intersection");
		javaTrained.retainAll(dotnetTrained);
		for(Employee employee:javaTrained) {
			System.out.println(employee);
		}
		
		
	}

}
