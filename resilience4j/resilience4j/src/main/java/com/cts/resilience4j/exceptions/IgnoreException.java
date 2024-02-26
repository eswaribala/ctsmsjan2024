package com.cts.resilience4j.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class IgnoreException extends RuntimeException{

	private String message;

	public IgnoreException(String message) {
		super();
		this.message = message;
	}
	
}
