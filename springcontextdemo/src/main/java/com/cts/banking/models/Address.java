package com.cts.banking.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Address {
	private String doorNo;
	private String streetName;
	private String city;
	private long pincode;

}
