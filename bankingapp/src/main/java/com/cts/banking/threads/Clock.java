package com.cts.banking.threads;

public class Clock extends Thread{
	
	private String tick() {
		return "tick";
	}
	
	private String tock() {
		return "tock";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<60;i++) {
			System.out.println(tick()+i+"\t"+tock()+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	

}
