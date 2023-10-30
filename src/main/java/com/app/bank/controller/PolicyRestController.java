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

import com.app.bank.entity.Policy;
import com.app.bank.service.IPolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyRestController {
	
	@Autowired
	IPolicyService policyService;
	
	@PostMapping("/save")
	public long savePolicy(@RequestBody Policy policy) {
		long newPolicyNumber = policyService.savePolicy(policy);
		return newPolicyNumber;
	}
	
	@GetMapping("/{policyNumber}")
	public Policy getPolicyByPolicyNumber(@PathVariable long policyNumber) {
		return policyService.getPolicyByPolicyNumber(policyNumber);
	}
	
	@GetMapping("/allpolicies")
	public ResponseEntity<List<Policy>> getAllAccounts(){
		List<Policy> tempList = policyService.getAllPolicies();
		System.out.println(tempList);
		return new ResponseEntity<List<Policy>>(tempList, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Policy> updatePremiumAmountOfPolicyByPolicyNumber(@RequestParam long policyNumber,@RequestParam int newPremiumAmount) {
		Policy savedPolicy = policyService.updatePremiumAmountOfPolicyByPolicyNumber(policyNumber, newPremiumAmount);
		
		Policy policy = new Policy();
		
		if(savedPolicy != null)
			return new ResponseEntity<Policy>(savedPolicy, HttpStatus.OK);
		else
			return new ResponseEntity<Policy>(policy, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/exp")
	public String checkExpiryDate(@RequestParam long policyNumber) {
		String status = policyService.checkExpiryDate(policyNumber);
		return status;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePolicyForAccount(@PathVariable long accountNumber) {
        policyService.deletePolicyForAccount(accountNumber);
        return ResponseEntity.ok("Policy deleted for Account with Account Number : " + accountNumber);
    }
}
