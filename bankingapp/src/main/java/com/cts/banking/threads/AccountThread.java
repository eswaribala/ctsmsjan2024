package com.cts.banking.threads;

import com.cts.banking.models.BankAccount;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class AccountThread implements Runnable{

	private BankAccount bankAccount;	
	private String threadName;
	private int amount;
	
	public AccountThread(BankAccount bankAccount, String threadName, int amount) {
		super();
		this.bankAccount = bankAccount;
		this.threadName = threadName;
		this.amount = amount;
		new Thread(this,this.threadName).start();
	}	
	
	@Override
	public void run() {
		System.out.println("In Run Method"+Thread.currentThread().getName());
		// TODO Auto-generated method stub
		synchronized(bankAccount) {
		bankAccount.withdraw(amount);
		}
	}	

}
