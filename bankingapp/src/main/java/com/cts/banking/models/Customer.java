package com.cts.banking.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private long accountNo;
	private FullName name;
	@Setter
	private String email;
	@Setter
	private long contactNo;
	private Address address;
	private String password;

}
