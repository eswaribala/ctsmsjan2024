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
	protected long runningTotal;
	protected LocalDate dop;
	//has relationship
	protected Customer customer;
	protected List<Transaction> transactionList;

}
