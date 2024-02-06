package com.cts.banking.utility;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import com.cts.banking.threads.ProducerThread;
import com.cts.banking.threads.ConsumerThread;
public class ProducerConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(10);
		
		Thread producerThread=new Thread(new ProducerThread(blockingQueue)
				,"Producer-Thread");
		
		Thread consumerThread=new Thread(new ConsumerThread(blockingQueue)
				,"Consumer-Thread");
		
		producerThread.start();
		consumerThread.start();

	}

}
