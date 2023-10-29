package com.app.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.Transaction;
import com.app.bank.repository.ITransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionRepository transactionRepository;

	@Override
	public long saveTransaction(Transaction transaction) {
		if (transaction != null) {
			Transaction savedTransaction = transactionRepository.save(transaction);
			return savedTransaction.getTransactionNumber();
		}
		return 0;
	}

	@Override
	public Transaction getTransactionById(long transactionNumber) {
		if (transactionNumber != 0) {
			Transaction savedTransaction = transactionRepository.findById(transactionNumber).get();
			return savedTransaction;
		}
		return null;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		List<Transaction> allTransaction = transactionRepository.findAll();
		if (allTransaction != null || allTransaction.size() != 0) {
			return allTransaction;
		} else
			return null;
	}

	@Override
	public void deleteTransactionById(long tid) {
		transactionRepository.deleteById(tid);

	}

	@Override
	public List<Transaction> findByOrderByTransactionAmount() {
		List<Transaction>sortedTransaction=transactionRepository.findByOrderByTransactionAmount();
		return sortedTransaction;
	}

	@Override
	public List<Transaction> findByOrderByTransactionAmountDesc() {
		List<Transaction>sortedTransaction=transactionRepository.findByOrderByTransactionAmountDesc();
		return sortedTransaction;
	}
	
	
	
	
	
	
}
