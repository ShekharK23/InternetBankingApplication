package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.entity.Account;
import com.app.bank.entity.Investment;
import com.app.bank.entity.Policy;
import com.app.bank.entity.Transaction;
import com.app.bank.service.IAccountService;
import com.app.bank.service.IInvestmentService;
import com.app.bank.service.IPolicyService;
import com.app.bank.service.ITransactionService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	IAccountService accountService;

	@Autowired
	IPolicyService policyService;

	@Autowired
	IInvestmentService investmentService;

	@Autowired
	ITransactionService transactionService;

	@PostMapping("/registernew") //working
	public long saveAccount(@RequestBody Account a) {
		long newId =  accountService.saveAccounts(a);
		return newId;
	}

	@GetMapping("/getbynum/{id}") //working
	public Account getAccountById(@PathVariable int id)
	{
		return accountService.getAccountByAccountNumber(id);
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

	@PutMapping("/investmenttoacc") //working
	public ResponseEntity<String> allocateInvestmentToAccount(@RequestParam long acId,@RequestParam long iId) {

		String status = accountService.addInvestmentToAccount(acId, iId);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	// Transaction Actions

	@PostMapping("/addTransaction")
	public long saveTransaction(@RequestBody Transaction transaction) {
		long transCode = transactionService.saveTransaction(transaction);
		return transCode;
	}

	@GetMapping("/getTransactionById")
	public ResponseEntity<Transaction> getTransactionById(@RequestParam long id) {
		Transaction transSaved = transactionService.getTransactionById(id);
		return new ResponseEntity<Transaction>(transSaved, HttpStatus.OK);
	}

	@GetMapping("/getTransactionLowToHigh")
	public ResponseEntity<List<Transaction>> findByOrderByTransactionAmount(){
		List<Transaction>lowToHigh = transactionService.findByOrderByTransactionAmount();
		return new ResponseEntity<List<Transaction>>(lowToHigh, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getTransactionHighToLow")
	public ResponseEntity<List<Transaction>> findByOrderByTransactionAmountDesc(){
		List<Transaction>highToLow = transactionService.findByOrderByTransactionAmountDesc();
		return new ResponseEntity<List<Transaction>>(highToLow, HttpStatus.ACCEPTED);
	}

	@GetMapping("/byTransactionByDate")
	public List<Transaction> getTransactionByTransactionDate(@RequestParam String td) {
		List<Transaction> t=transactionService.getTransactionByTransactionDate(td);
		return t;
	}

	//Policy Works

	@GetMapping("/policy/{policyNumber}")
	public Policy getPolicyByPolicyNumber(@PathVariable long policyNumber) {
		return policyService.getPolicyByPolicyNumber(policyNumber);
	}

	@GetMapping("/policy/allpolicies")
	public ResponseEntity<List<Policy>> getAllPolicies(){
		List<Policy> tempList = policyService.getAllPolicies();
		System.out.println(tempList);
		return new ResponseEntity<List<Policy>>(tempList, HttpStatus.OK);
	}

	@GetMapping("/policy/date")
	public String checkExpiryDate(@RequestParam long policyNumber) {
		String status = policyService.checkExpiryDate(policyNumber);
		return status;
	}

	// Investment Works

	@PostMapping("/investment/save")
	public String addInvestment(@RequestBody Investment investment) {
		String notification = investmentService.addInvestment(investment);
		return notification;
	}

	@GetMapping("/investment/fetch/inv")
	public Investment getInvestmentByFdNumber(@RequestParam long fdNumber) {
		Investment savedInvestment = investmentService.getInvestmentByFdNumber(fdNumber);
		return savedInvestment;
	}

	@GetMapping("/investment/allinvestments")
	public ResponseEntity<List<Investment>> getAllInvestments(){
		List<Investment> tempList = investmentService.getAllInvestments();
		System.out.println(tempList);
		return new ResponseEntity<List<Investment>>(tempList, HttpStatus.OK);
	}

	@PutMapping("/investment/update")
	public ResponseEntity<Investment> updateTermMonthOfInvestmentByFdNumber(@RequestParam long fdNumber, @RequestParam int newFdTermMonths) {
		Investment savedInvestment = investmentService.updateTermMonthOfInvestmentByFdNumber(fdNumber, newFdTermMonths);
		Investment investment = new Investment();

		if(savedInvestment != null)
			return new ResponseEntity<Investment>(savedInvestment, HttpStatus.OK);
		else
			return new ResponseEntity<Investment>(investment, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/investment/date")
	public String checkMaturityDate(@RequestParam long fdNumber) {
		String status = investmentService.checkMaturityDate(fdNumber);
		return status;
	}

	@DeleteMapping("/investment/delete")
	public ResponseEntity<String> deleteInvestmentForAccount(@RequestParam long accountNumber) {
		investmentService.deleteInvestmentForAccount(accountNumber);
		return ResponseEntity.ok("Investments For Account Number : "+accountNumber+" Deleted");
	}

}