package com.app.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.Account;
import com.app.bank.entity.Beneficiary;
import com.app.bank.entity.Investment;
import com.app.bank.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;
	
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
//
//	@Override
//	public Account addInvestmentToAccount(long accNum, Investment investment) {
//		return null;
//	}
//
//	@Override
//	public String allocateTransactionToAccount(long transactionId, long accNum) {
//		return null;
//	}
//
//	@Override
//	public String allocatePolicyToAccount(long accNum, long policyNum) {
////		Account savedAcc = getAccountByAccountNumber(accNum); // fetch employee from table 
//		//Policy policy = policyRepository.findById(policyId).get();  // fetch insurance from table
//		//if(savedAcc != null && policy != null) // if both are not null / exist in table
//		//{
//		//	savedAcc.setPolicy(policy);// call update query on employee table to add insurance
//		//	return savedAcc;
//		//}
//		return null;
//	}

}
