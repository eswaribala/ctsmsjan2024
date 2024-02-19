package com.cts.banking.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmployeeBeanPostProcessor implements BeanPostProcessor{
   private static final Logger logger=LoggerFactory.getLogger(EmployeeBeanPostProcessor.class);
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("Object Name"+bean.getClass().getName());
		// TODO Auto-generated method stub
		if(bean.getClass().getName().contains(beanName))
			logger.info("Entering Employee Bean Processor Before Initialization...");
		else
			logger.info("Entering Bean Processor Before Initialization...");
		
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Entering Bean Post processor after initialization"+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	

}
