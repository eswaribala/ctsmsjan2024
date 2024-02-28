package com.cts.banking.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	private static File file;
	private static FileWriter fileWriter;
	private static String filePath="E:\\ctsjan2024ws\\bankingapp";	
	private Customer customer;
	@BeforeAll
	public static void createFile() throws IOException {
		
		file=new File(filePath,"test.csv");
		fileWriter=new FileWriter(file,true);		
	}
	@BeforeEach
	public void createCustomerInstance() {
		customer=new Customer();
	}
	@Test
	public void isCustomerNotNull() {
	
		assertNotNull(customer);
	}
	
	@AfterEach
	public void resetInstance() {
		customer=null;
	}
	
	@AfterAll
	public static void closeFile() throws IOException {
		fileWriter.close();
	}
	
}
