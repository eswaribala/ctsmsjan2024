package com.cts.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
	
	private int money;
	
	
	public void withdraw(int amount) {
		
		if(amount<money) {
			System.out.println("Transaction Initiated...");
			money=money-amount;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Money deducted and available balance="+money);
		}else {
			System.out.println("Transaction cannot be Initiated because the available money"
					+ "less than the amount. Try Later....");
			System.out.println("Available balance="+money);
		}
		
	}
	

}
