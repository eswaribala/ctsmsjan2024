package com.cts.bankingretailapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bankingretailapi.models.Account;


public interface AccountRepository extends JpaRepository<Account,Long>{

}
