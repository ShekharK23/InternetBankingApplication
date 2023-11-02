package com.app.bank.util;

import org.springframework.stereotype.Component;

import com.app.bank.dto.AccountAddDTO;
import com.app.bank.entity.Account;

@Component
public class AccountAddConverter {

	public Account getAccountFromAccountDTO(AccountAddDTO dto)
	{
		Account a = new Account();
		
		a.setAccountHolderName(dto.getAccountHolderName());
		a.setAccountHolderAge(dto.getAccountHolderAge());
		a.setAccountBalance(dto.getAccountBalance());
		a.setPanNumber(dto.getPanNumber());
		a.setAccountType(dto.getAccountType());
		
		return a;
	}
}
