package com.cts.banking.utility;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import com.cts.banking.models.Transaction;

public class TransactionApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter no of rows");
		int rows=scanner.nextInt();
		//jagged array
		Transaction[][] transactions=new Transaction[rows][];
		int cols=0;
		//supply data
		for(int i=0;i<transactions.length;i++) {
			System.out.println("Enter no of cols");
			cols=scanner.nextInt();
			transactions[i]=new Transaction[cols];
			for(int j=0;j<transactions[i].length;j++) {
				transactions[i][j]=new Transaction(
						new Random().nextInt(100000),
						LocalDateTime.now(),new Random().nextInt(10000),
						"Sender"+j,"Receiver"+j,null);			}		
			
		}
		Transaction transaction=null;
		//show data
		for(int i=0;i<transactions.length;i++) {
			for(int j=0;j<transactions[i].length;j++) {
				
				transaction=transactions[i][j];
				System.out.print(transaction.getTransactionId()+","+
				transaction.getTimestamp()+","+transaction.getAmount()+"\t");
			}
			System.out.println("\n");
		}
		
		
		

	}

}
