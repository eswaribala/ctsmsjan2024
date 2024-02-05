package com.cts.banking.facades;

import java.util.Random;

@FunctionalInterface
public interface DataSupplier<T> {

	T getData();
	
	public static int getOTP() {
		return new Random().nextInt(9999);
	}
}
