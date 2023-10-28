package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.entity.Account;
import com.app.bank.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountRestController {

	@Autowired
	IAccountService accountService;
	
	@PostMapping("/registernew")
	public long saveAccount(@RequestBody Account a) {
		long newId =  accountService.saveAccounts(a);
		 return newId;
	}
	
	@GetMapping("/accounts")  
	public ResponseEntity<List<Account>> getAccounts()
	{
		System.out.println("inside controller getAccounts()");
		List<Account> temp =  accountService.getAllAccounts();
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity <List<Account>>(temp, HttpStatus.OK);
	}
}
