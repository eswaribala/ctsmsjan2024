package com.cts.banking.models;

import org.springframework.stereotype.Component;

import com.cts.banking.facades.DataSource;
@Component
public class OracleDataSource implements DataSource{

	@Override
	public boolean store(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

}
