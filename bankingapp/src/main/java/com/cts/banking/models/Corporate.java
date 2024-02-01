package com.cts.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Corporate extends Customer{
	private CompanyType companyType;

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
