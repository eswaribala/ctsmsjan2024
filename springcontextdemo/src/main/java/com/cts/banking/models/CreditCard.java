package com.cts.banking.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	
	private long cardNo;
	private LocalDate expiryDate;
	private long limit;
	

}
