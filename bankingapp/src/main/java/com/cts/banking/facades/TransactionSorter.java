package com.cts.banking.facades;

import java.util.Comparator;

import com.cts.banking.models.Transaction;

public class TransactionSorter implements Comparator<Transaction>{

	@Override
	public int compare(Transaction o1, Transaction o2) {
		// TODO Auto-generated method stub
		if(o1.getTransactionId()>o2.getTransactionId())
			return 1;
		else if(o1.getTransactionId()<o2.getTransactionId())
			return -1;
		else
			return 0;
	}

}
