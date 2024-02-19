package com.cts.banking.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.cts.banking.facades.LoggerV1;

public class FileLogger implements LoggerV1 {
	
	private File file;
	private FileWriter fileWriter;
	
	public FileLogger() throws IOException {
		file=new File("messages.csv");
		fileWriter=new FileWriter(file,true);
	}

	@Override
	public void writeToLog(Message message) throws IOException {
		// TODO Auto-generated method stub
		fileWriter.write(message.getMessageId()+"\t");
		fileWriter.write(message.getLogLevel()+"\t");
		fileWriter.write(message.getDescription()+"\t");
		fileWriter.write(message.getTimeStamp().toString()+"\n");
	    fileWriter.close();
		
	}

}
