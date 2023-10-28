package com.app.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>{

	public List<Account> getAccountByAccountType(String accountType);
//	public List<Account> getAccountByBranch(String branch);
	
}
