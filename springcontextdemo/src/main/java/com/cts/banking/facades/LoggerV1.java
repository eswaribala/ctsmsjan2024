package com.cts.banking.facades;

import java.io.IOException;

import com.cts.banking.models.Message;

public interface LoggerV1 {
	
	void writeToLog(Message message) throws IOException;

}
