package com.cts.banking.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class DirectDebitTransaction extends Transaction implements Runnable{
	private LocalDate paymentDate;
    //private String threadName;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//this.setThreadName(threadName);
		for(int i=0;i<5;i++) {
		System.out.println(Thread.currentThread().getId()+"\t"
		+Thread.currentThread().getName()+"\t"+Thread.currentThread().isAlive()
		+"\t"+Thread.currentThread().getPriority()+"\t"
		+Thread.currentThread().getState());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
