package com.cts.banking.utility;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class DateTimeAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.
			ofPattern("dd/MMM/yyyy - HH:mm:ss");	
		
	 ZoneId.getAvailableZoneIds().stream().sorted()	
	 .forEach(z->System.out.println(z+"=>"+dateTimeFormatter.format
			 (LocalDateTime.now(ZoneId.of(z)))));
	 
	 
	 

	}

}
