package com.cts.banking.models;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.cts.banking.facades.DataSource;
import com.cts.banking.facades.LoggerV1;
import com.cts.banking.utility.LoggerTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@Import({Customer.class, Transaction.class,MySQLDataSource.class, OracleDataSource.class})
public class Account {
	private static final Logger logger=LoggerFactory.getLogger(Account.class);
	
	protected long runningTotal;
	protected LocalDate dop;
	//has relationship
	@Autowired
	protected Customer customer;
	@Autowired
	protected List<Transaction> transactionList;
	
	@Autowired 
	public Account(DataSource dataSource) {
		logger.info("Bean Instantiated...");
	}
	
	
	@Bean
	public Audit getAudit() {
		return new Audit();
	}



	
	
}
