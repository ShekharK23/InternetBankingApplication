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

import com.app.bank.dto.AccountAddDTO;
import com.app.bank.entity.Account;
import com.app.bank.entity.Investment;
import com.app.bank.entity.Policy;
import com.app.bank.entity.Transaction;
import com.app.bank.service.IAccountService;
import com.app.bank.service.IInvestmentService;
import com.app.bank.service.IPolicyService;
import com.app.bank.service.ITransactionService;
import com.app.bank.util.AccountAddConverter;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.service.Contact;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	IAccountService accountService;

	@Autowired
	AccountAddConverter accountAddConverter;

	@Autowired
	ITransactionService transactionService;

	@Autowired
	IInvestmentService investmentService;

	@Autowired
	IPolicyService policyService;

	@PostMapping("/regnewaccount") //working
	@ApiOperation(value = "Register New Account",
		notes = "Add all parameters for creating an Account.",
		response = Contact.class)
	public long saveAccount(@RequestBody Account a) {
		long newId =  accountService.saveAccounts(a);
		return newId;
	}

	@GetMapping("/getallaccounts")  //working
	@ApiOperation(value = "Get All Available Accounts",
		notes = "You will get all accounts available in the database.",
		response = Contact.class)
	public ResponseEntity<List<Account>> getAccounts()
	{
		List<Account> temp =  accountService.getAllAccounts();
		System.err.println(temp.size());
		System.out.println(temp);
		return new ResponseEntity <List<Account>>(temp, HttpStatus.OK);
	}

	@GetMapping("/getaccbyaccnum/{id}") //working
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

	@PostMapping("/registernewaccbydto") // working
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

	@PutMapping("/investmenttoacc") //working
	public ResponseEntity<String> allocateInvestmentToAccount(@RequestParam long acId,@RequestParam long iId) {

		String status = accountService.addInvestmentToAccount(acId, iId);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	// transaction actions

	@GetMapping("/getTransactionById")
	public ResponseEntity<Transaction> getTransactionById(@RequestParam long id) {
		Transaction transSaved = transactionService.getTransactionById(id);
		return new ResponseEntity<Transaction>(transSaved, HttpStatus.OK);
	}

	@GetMapping("/getAllTransaction")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		List<Transaction> all = transactionService.getAllTransaction();

		return new ResponseEntity<List<Transaction>>(all, HttpStatus.OK);
	}

	@DeleteMapping("/deleteTransactionById/{tid}")
	public String deleteTransactionById(@PathVariable long tid) {
		System.out.println("Requested transaction for given ID is deleted");
		transactionService.deleteTransactionById(tid);
		return "The requested transaction is deleted for ID:_"+tid+" ";

	}

	@GetMapping("/getTransactionLowToHigh")
	public ResponseEntity<List<Transaction>> findByOrderByTransactionAmount(){
		List<Transaction>lowToHigh=transactionService.findByOrderByTransactionAmount();
		return new ResponseEntity<List<Transaction>>(lowToHigh, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getTransactionHighToLow")
	public ResponseEntity<List<Transaction>> findByOrderByTransactionAmountDesc(){
		List<Transaction>highToLow=transactionService.findByOrderByTransactionAmountDesc();
		return new ResponseEntity<List<Transaction>>(highToLow, HttpStatus.ACCEPTED);
	}

	@GetMapping("/byTransactionByDate")
	public List<Transaction> getTransactionByTransactionDate(@RequestParam String td) {
		List<Transaction> t=transactionService.getTransactionByTransactionDate(td);
		return t;
	}

	// Investment Actions

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

	// Policy actions

	@PostMapping("/policy/save")
	public long savePolicy(@RequestBody Policy policy) {
		long newPolicyNumber = policyService.savePolicy(policy);
		return newPolicyNumber;
	}

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

	@PutMapping("/policy/update")
	public ResponseEntity<Policy> updatePremiumAmountOfPolicyByPolicyNumber(@RequestParam long policyNumber,@RequestParam int newPremiumAmount) {
		Policy savedPolicy = policyService.updatePremiumAmountOfPolicyByPolicyNumber(policyNumber, newPremiumAmount);
		Policy policy = new Policy();

		if(savedPolicy!=null) 
			return new ResponseEntity<Policy>(savedPolicy, HttpStatus.OK);
		else return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}

	@GetMapping("/policy/date")
	public String checkExpiryDate(@RequestParam long policyNumber) {
		String status = policyService.checkExpiryDate(policyNumber);
		return status;
	}

	@DeleteMapping("/policy/delete")
	public ResponseEntity<String> deletePolicyForAccount(@RequestParam long accountNumber) {
		policyService.deletePolicyForAccount(accountNumber);
		return ResponseEntity.ok("Investments For Account Number : "+accountNumber+" Deleted");
	}

}