package com.cts.banking.models;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private long runningTotal;
	private LocalDate dop;
	//has relationship
	private Customer customer;
	private List<Transaction> transactionList;

}
