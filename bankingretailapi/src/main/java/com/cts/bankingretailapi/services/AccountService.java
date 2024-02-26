package com.cts.bankingretailapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.bankingretailapi.dtos.ResponseWrapper;
import com.cts.bankingretailapi.models.Account;

import com.cts.bankingretailapi.repositories.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${serviceUrl}")
	private String serviceUrl;
	
	private ResponseEntity responseEntity;
	
	public Account addAccount(Account account) {
		
		if(account.getAccountNo()>0) {
			
		    responseEntity=restTemplate.exchange(serviceUrl+account.getAccountNo(),
					HttpMethod.GET,null,ResponseEntity.class);
			log.info("Response"+responseEntity);
			return this.accountRepository.save(account);
		}
		else {
			return null;
		}
	}
	
	
	public List<Account> getAccounts(){
		return this.accountRepository.findAll();
	}

	//search by contact no (non primary key)
	
	public List<Account> getAccountsByDop(LocalDate dop){
		
		CriteriaBuilder cb= entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> cq= cb.createQuery(Account.class);
		Root<Account> root= cq.from(Account.class);
		cq.where(cb.equal(root.get("dop"), dop));
		CriteriaQuery<Account> result=cq.select(root);
		TypedQuery<Account> typedQuery= entityManager.createQuery(result);
		return typedQuery.getResultList();
		
	}
	
}
