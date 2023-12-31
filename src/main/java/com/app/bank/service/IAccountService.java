package com.app.bank.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.app.bank.entity.Account;
import com.app.bank.entity.Investment;

@Service
public interface IAccountService {
	
	public long saveAccounts(Account a);
	public List<Account> getAllAccounts();
	
	public Account getAccountByAccountNumber(long accNum);
	public List<Account> getAllAccountsByAccountType(String accType);
//	
//	public List<Account> getAccountByBranch(String branchName);
//	
//	public String addBeneficiaryToAccount(long accNum,Beneficiary beneficiary);
//	public Account addDebitCardToAccount(long accNum,long debitCardNum);
//	public Account addCreditCardToAccount(long accNum,long creditCardNum);
//	public Account addBranchToAccount(long accNum,int branchIFSC);
	public String addInvestmentToAccount(long accNum,long investmentNum);
	public String allocateTransactionToAccount(long transactionId, long accNum);
	public String allocatePolicyToAccount(long accNum, long policyNum);
}
