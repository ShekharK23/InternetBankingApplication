package com.app.bank.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.bank.entity.Transaction;



@Service
public interface ITransactionService {
	
	public long saveTransaction(Transaction transaction);
	public Transaction getTransactionById(long transactionNumber );
	public List<Transaction>getAllTransaction();
	public String deleteTransactionById(long tid);
	public List<Transaction>findByOrderByTransactionAmount();
	public List<Transaction>findByOrderByTransactionAmountDesc();
	public List<Transaction> getTransactionByTransactionDate(String TransactionDate );

	
}
