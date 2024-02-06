package com.cts.banking.utility;

import com.cts.banking.models.Vehicle;
import com.cts.banking.threads.Simulation;

public class SimulationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Vehicle[] vehicle=new Vehicle[5];
       
       for(int i=0;i<vehicle.length;i++) {
    	   vehicle[i]=new Vehicle("TN-32-KA-3211"+i);
    	   new Simulation(vehicle[i],"Thread-"+i);
    	   
       }
       
		
	}

}
