package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.dto.AccountAddDTO;
import com.app.bank.entity.Account;
import com.app.bank.service.IAccountService;
import com.app.bank.util.AccountAddConverter;

@RestController
@RequestMapping("/account")
public class AccountRestController {

	@Autowired
	IAccountService accountService;
	
	@Autowired
	AccountAddConverter accountAddConverter;
	
	@PostMapping("/registernew") //working
	public long saveAccount(@RequestBody Account a) {
		long newId =  accountService.saveAccounts(a);
		return newId;
	}
	
	@GetMapping("/getallaccounts")  //working
	public ResponseEntity<List<Account>> getAccounts()
	{
		List<Account> temp =  accountService.getAllAccounts();
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity <List<Account>>(temp, HttpStatus.OK);
	}
	
	@GetMapping("/getbynum/{id}") //working
	public Account getAccountById(@PathVariable int id)
	{
		return accountService.getAccountByAccountNumber(id);
	}
	
	@GetMapping("/getaccbytype") //working
	public ResponseEntity<List<Account>> getAccountByType(@RequestParam String type){
		List<Account> temp = accountService.getAllAccountsByAccountType(type);
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity<List<Account>>(temp,HttpStatus.OK);
	}
	
	@PostMapping("/registernewdto") // working
	public long saveAccountdto(@RequestBody AccountAddDTO dto)
	{
		Account a = accountAddConverter.getAccountFromAccountDTO(dto);
		long newId =  accountService.saveAccounts(a);
		return newId;
	}
	
	@PutMapping("/transtoacc") //working
	public ResponseEntity<String> allocateTransactionToAccount(@RequestParam long tsId,@RequestParam long acId) {

		String status = accountService.allocateTransactionToAccount(tsId, acId);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}
	
	@PutMapping("/policytoacc") //working
	public ResponseEntity<String> allocatePolicyToAccount(@RequestParam long acId,@RequestParam long pId) {

		String status = accountService.allocatePolicyToAccount(acId, pId);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}
}
