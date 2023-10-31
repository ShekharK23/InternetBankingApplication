package com.app.bank.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long>{
	
	public List<Transaction>findByOrderByTransactionAmount();
	public List<Transaction>findByOrderByTransactionAmountDesc();
	public List<Transaction> getTransactionByTransactionDate(String TransactionDate );

}
