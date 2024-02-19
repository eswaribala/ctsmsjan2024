package com.cts.banking.models;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Message {
	
	private String messageId;
	private String logLevel;
	private String description;
	private LocalDateTime timeStamp;

}
