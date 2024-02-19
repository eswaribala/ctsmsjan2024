package com.cts.banking.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@Import({EmployeeConfig.class})
public class Employee implements BeanNameAware, InitializingBean,
DisposableBean, ApplicationContextAware, BeanFactoryAware{
	
	private static final Logger logger=LoggerFactory.getLogger(Employee.class);

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Entering Disposable Bean....");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Initializing Bean....");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		logger.info("Entering Bean Name Aware....");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Entering Application Context....");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
		logger.info("Entering Bean Factory...."+beanFactory.getBean("employee").toString());
		
	}
	
	@PostConstruct
	public void customIntit() {
		
		logger.info("Entering custom Initialization method....");
	}
	
	@PreDestroy
	public void customDelete() {
		logger.info("Before Destroying bean invokes custom destory method....");
	}

}
