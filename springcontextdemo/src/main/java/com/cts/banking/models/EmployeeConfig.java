package com.cts.banking.models;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EmployeeConfig {
	@Bean
	public BeanPostProcessor getBeanPostProcess() {
		return new EmployeeBeanPostProcessor();
	}
}
