package com.cts.banking.utility;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cts.banking.models.Employee;
import com.cts.banking.models.EmployeeBeanPostProcessor;

public class SpringLifeCycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext annotationConfig=new 
				AnnotationConfigApplicationContext();
		annotationConfig.register(Employee.class);
		annotationConfig.refresh();
		
		Employee employee=(Employee) annotationConfig.getBean("employee");
		
		annotationConfig.registerShutdownHook();

	}
	


}
