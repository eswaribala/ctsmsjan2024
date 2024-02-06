package com.cts.banking.models;

import java.time.LocalDateTime;

import com.cts.banking.facades.TransactionFacade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements TransactionFacade{
	protected long transactionId;
	protected LocalDateTime timestamp;
	protected long amount;
	protected String senderName;
	protected String receiverName;
	//has relationship
	protected Account account;
	
}
