package com.cts.banking.threads;
import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable {
	
	private BlockingQueue<String> blockingQueue;	
	
	public ProducerThread(BlockingQueue<String> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}
	public void producer() {
		
		for(int i=0;i<100;i++) {
			try {
				System.out.println("Producer Writing....");
				blockingQueue.put("Message"+i);
				if(i==99) {
					blockingQueue.put("exit");
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Enters the Producer");
		producer();
	}

}
