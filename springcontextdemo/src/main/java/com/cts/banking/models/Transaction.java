package com.cts.banking.models;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cts.banking.facades.LoggerV1;
import com.cts.banking.models.Account;
import com.cts.banking.models.FileLogger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class Transaction{
	protected long transactionId;
	protected LocalDateTime timestamp;
	protected long amount;
	protected String senderName;
	protected String receiverName;
	//has relationship
	@Autowired
	protected Account account;
	@Bean
	
	public LoggerV1 getLogger() throws IOException {
		return new FileLogger();
	}
	
	
	
}
