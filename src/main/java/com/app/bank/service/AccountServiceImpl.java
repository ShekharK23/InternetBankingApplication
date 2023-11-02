package com.app.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.Account;
import com.app.bank.entity.Investment;
import com.app.bank.entity.Policy;
import com.app.bank.entity.Transaction;
import com.app.bank.repository.IAccountRepository;
import com.app.bank.repository.IInvestmentRepository;
import com.app.bank.repository.IPolicyRepository;
import com.app.bank.repository.ITransactionRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;
	
	@Autowired
	ITransactionRepository transactionRepository;
	
	@Autowired
	IPolicyRepository policyRepository;
	
	@Autowired
	IInvestmentRepository investmentRepository;
	
	@Override
	public long saveAccounts(Account a) {
		Account savedAccount = accountRepository.save(a);
		if(a != null) {
			return savedAccount.getAccountNumber();
		}
		else return 0;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> allSavedAccounts = accountRepository.findAll();
		if(allSavedAccounts != null)
		{
			return allSavedAccounts;
		}
		else return null;
	}

	@Override
	public Account getAccountByAccountNumber(long accNum) {
		Account savedAccount = accountRepository.findById(accNum).get();
		if(savedAccount != null) {
			return savedAccount;
		}
		else return null;
	}

	@Override
	public List<Account> getAllAccountsByAccountType(String accType) {
		return accountRepository.getAccountByAccountType(accType);
	}

//	@Override
//	public List<Account> getAccountByBranch(String branchName) {
//		return accountRepository.getAccountByBranch(branchName);
//	}
//
//	@Override
//	public String addBeneficiaryToAccount(long accNum, Beneficiary beneficiary) {
//		return null;
//	}
//
//	@Override
//	public Account addDebitCardToAccount(long accNum, long debitCardNum) {
//		return null;
//	}
//
//	@Override
//	public Account addCreditCardToAccount(long accNum, long creditCardNum) {
//		return null;
//	}
//
//	@Override
//	public Account addBranchToAccount(long accNum, int branchIFSC) {
//		return null;
//	}

	@Override
	@Transactional
	public String addInvestmentToAccount(long accNum,long investmentNum) {
		String status = "";
		Account a = accountRepository.findById(accNum).get();		
		Investment i = investmentRepository.findById(investmentNum).get();
		if(a != null && i != null)
		{
			List<Investment> allInvestments = a.getAllInvestment();
			allInvestments.add(i);
			a.setAllInvestment(allInvestments);
			status = "Investment allocated , Investment Count : - "+ a.getAllInvestment().size();
		}
		else 
		{
			status = "Investment "+i+" or Account "+a+" Is not Valid.";
		}
		return status;
	}

	@Override
	@Transactional
	public String allocateTransactionToAccount(long transactionNum, long accountNum) {
		String status = "";
		Account a = accountRepository.findById(accountNum).get();		
		Transaction t = transactionRepository.findById(transactionNum).get();
		if(a != null && t != null)
		{
			List<Transaction> allTransactions = a.getAllTransactions();
			allTransactions.add(t);
			a.setAllTransactions(allTransactions);
			status = "Transaction allocated , Transaction Count : - "+ a.getAllTransactions().size();
		}
		else 
		{
			status = "Transaction "+t+" or Account "+a+" Is not Valid.";
		}
		return status;
	}
	
//	@Override
//	public String allocateTransactionToAccount(long transactionId, long accNum) {
//		return null;
//	}
//
	
	@Override
	@Transactional
	public String allocatePolicyToAccount(long accountNum, long policyNum) {
		String status = "";
		Account a = accountRepository.findById(accountNum).get();		
		Policy p = policyRepository.findById(policyNum).get();
		if(a != null && p != null)
		{
			List<Policy> allPolicy = a.getAllPolicy();
			allPolicy.add(p);
			a.setAllPolicy(allPolicy);
			status = "Policy allocated , Policy Count : - "+ a.getAllPolicy().size();
		}
		else 
		{
			status = "Policy "+p+" or Account "+a+" Is not Valid.";
		}
		return status;
	}

}
