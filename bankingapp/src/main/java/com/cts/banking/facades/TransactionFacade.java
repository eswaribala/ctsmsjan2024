package com.cts.banking.facades;

public interface TransactionFacade {
	
	default boolean validateTransaction() {
		return false;
	}

}
