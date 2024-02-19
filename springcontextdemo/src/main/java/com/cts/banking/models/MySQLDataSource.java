package com.cts.banking.models;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.cts.banking.facades.DataSource;

@Component
@Primary
public class MySQLDataSource implements DataSource{

	@Override
	public boolean store(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

}
