package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.entity.Transaction;
import com.app.bank.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
	
	@Autowired
	ITransactionService transactionService;
	
	@PostMapping("/save")
	public long saveTransaction(@RequestBody Transaction transaction) {
		long transCode=transactionService.saveTransaction(transaction);
		return transCode;
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Transaction>getTransactionById(@RequestParam long id){
		Transaction transSaved=transactionService.getTransactionById(id);
		return new ResponseEntity<Transaction>(transSaved,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTransaction")
	public ResponseEntity<List<Transaction>>getAllTransaction(){
		List<Transaction> all=transactionService.getAllTransaction();
		
		return new ResponseEntity<List<Transaction>>(all,HttpStatus.OK);
	}

}
