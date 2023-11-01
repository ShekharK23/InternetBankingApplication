package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.entity.Investment;
import com.app.bank.service.IInvestmentService;

@RestController
@RequestMapping("/investment")
public class InvestmentRestController {

	@Autowired
	IInvestmentService investmentService;
	
	@PostMapping("/save")
	public String addInvestment(@RequestBody Investment investment) {
		String notification = investmentService.addInvestment(investment);
		return notification;
	}
	
	@GetMapping("/fetch/inv")
	public Investment getInvestmentByFdNumber(@RequestParam long fdNumber) {
		Investment savedInvestment = investmentService.getInvestmentByFdNumber(fdNumber);
		return savedInvestment;
	}
	
	@GetMapping("/allinvestments")
	public ResponseEntity<List<Investment>> getAllInvestments(){
		List<Investment> tempList = investmentService.getAllInvestments();
		System.out.println(tempList);
		return new ResponseEntity<List<Investment>>(tempList, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Investment> updateTermMonthOfInvestmentByFdNumber(@RequestParam long fdNumber, @RequestParam int newFdTermMonths) {
		Investment savedInvestment = investmentService.updateTermMonthOfInvestmentByFdNumber(fdNumber, newFdTermMonths);
		Investment investment = new Investment();
		
		if(savedInvestment != null)
			return new ResponseEntity<Investment>(savedInvestment, HttpStatus.OK);
		else
			return new ResponseEntity<Investment>(investment, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/date")
	public String checkMaturityDate(@RequestParam long fdNumber) {
		String status = investmentService.checkMaturityDate(fdNumber);
		return status;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteInvestmentForAccount(@RequestParam long accountNumber) {
		investmentService.deleteInvestmentForAccount(accountNumber);
		return ResponseEntity.ok("Investments For Account Number : "+accountNumber+" Deleted");
	}
}
