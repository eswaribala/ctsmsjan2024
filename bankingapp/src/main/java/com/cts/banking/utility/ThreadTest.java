package com.cts.banking.utility;

import com.cts.banking.models.BankAccount;
import com.cts.banking.threads.AccountThread;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount bankAccount=new BankAccount(1000);
		new AccountThread(bankAccount,"Thread-A",500);
		new AccountThread(bankAccount,"Thread-B",750);
		
	}

}
