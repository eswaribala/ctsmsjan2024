package com.cts.banking.threads;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable{
	
	private BlockingQueue<String> blockingQueue;	

	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}
	
	public void consumer() {
		String msg=null;
		try {
			while((msg=blockingQueue.take())!="exit") {
				try {
					System.out.println("Consumer Reading....");
					System.out.println(msg);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Enters the Consumer");
		consumer();
	}

}
