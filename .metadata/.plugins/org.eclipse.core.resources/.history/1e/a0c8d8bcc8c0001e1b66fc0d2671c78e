package com.cts.banking.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private long transactionId;
	private LocalDateTime timestamp;
	private long amount;
	private String senderName;
	private String receiverName;
	//has relationship
    private Account account;
}
