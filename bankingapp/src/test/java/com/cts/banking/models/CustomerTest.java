package com.cts.banking.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
	
	@ParameterizedTest
	@MethodSource("provideCustomerData")
	public void customerDataTest(long accountNo, long contactNo, 
			String email, String password) {
		customer.setAccountNo(accountNo);
		customer.setContactNo(contactNo);
		customer.setEmail(email);
		customer.setPassword(password);
		assertTrue(customer.getPassword().startsWith("T"));
		
	}
	
	@AfterEach
	public void resetInstance() {
		customer=null;
	}
	
	@AfterAll
	public static void closeFile() throws IOException {
		fileWriter.close();
	}
	
	
	private static Stream<Arguments> provideCustomerData() {
	    return Stream.of(
	      Arguments.of(43865834, 458348587, "param@gmail.com", "Test@123"),
	      Arguments.of(43865835, 458348588, "param1@gmail.com", "Test@124"),
	      Arguments.of(43865836, 458348589, "param2@gmail.com", "Test@125"),
	      Arguments.of(43865837, 458348585, "param3@gmail.com", "Test@126")
	    );
	}
	
}
