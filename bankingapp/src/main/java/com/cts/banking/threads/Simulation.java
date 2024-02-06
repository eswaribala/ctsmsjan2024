package com.cts.banking.threads;

import com.cts.banking.models.Bridge;
import com.cts.banking.models.TollBooth;
import com.cts.banking.models.Vehicle;

public class Simulation implements Runnable{
	
	private Vehicle vehicle;		

	public Simulation(Vehicle vehicle, String threadName) {
		super();
		this.vehicle = vehicle;
		new Thread(this,threadName).start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized(vehicle) {
			System.out.println("Vehicle RegNo="+this.vehicle.getRegNo()+"->"
		   +TollBooth.tollMessage()+"->"+Bridge.bridgeMessage());
		}
	}

}
