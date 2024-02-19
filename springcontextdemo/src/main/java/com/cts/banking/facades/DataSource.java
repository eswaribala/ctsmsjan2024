package com.cts.banking.facades;

import com.cts.banking.models.Message;

public interface DataSource {
	
	boolean store(Message message);

}
