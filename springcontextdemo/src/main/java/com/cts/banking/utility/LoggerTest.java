package com.cts.banking.utility;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.banking.facades.LoggerV1;
import com.cts.banking.models.Account;
import com.cts.banking.models.Audit;
import com.cts.banking.models.Message;
import com.cts.banking.models.Transaction;

import lombok.extern.java.Log;

import java.io.IOException;
import java.time.LocalDateTime;

//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;

@Log
public class LoggerTest {
	
	
	private static final Logger logger=LoggerFactory.getLogger(LoggerTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	ApplicationContext applicationContext=new 
	//			ClassPathXmlApplicationContext("banking-config.xml");
		
		//demonstrate import using annotation application context
	    
		
		AnnotationConfigApplicationContext annotationConfigApplicationContext= 
				new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(Account.class);
		annotationConfigApplicationContext.refresh();
		Account account=(Account) annotationConfigApplicationContext.getBean("account");
		
		Audit audit=account.getAudit();
		try {
			logger.info("Contents are wriiten to file");
			audit.getLogger().writeToLog(new Message("1","Info","Testing",LocalDateTime.now()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
