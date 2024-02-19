package com.cts.banking.utility;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


import com.cts.banking.models.Customer;
import com.cts.banking.models.Individual;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IOC
		//Step1			
			//  Resource resource=new ClassPathResource("banking-config.xml");		
		//Step 2		
			//BeanFactory beanFactory=new XmlBeanFactory(resource);
			
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("banking-config.xml"));		
			
	    Customer customer1=(Customer) factory.getBean("customer");
	    //customer.getAddresses().stream().forEach(System.out::println);
	    Customer customer2=(Customer) factory.getBean("customer");
	    customer2.setEmail("param@cognizant.com");
	    System.out.println(customer1.getEmail());
	    
	    Individual individual=(Individual) factory.getBean("individual");
	    System.out.println(individual);
	    
	}

}
