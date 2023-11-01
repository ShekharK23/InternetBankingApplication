package com.app.bank.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.entity.Beneficiary;
import com.app.bank.service.IBeneficiaryService;

@RestController
@RequestMapping("/brnificiary")
public class BenificiaryRestController {

		@Autowired
		IBeneficiaryService benificiaryService;
		
		@PostMapping("/save")
		public long addNewBeneficiary(Beneficiary beneficiary) {
			return benificiaryService.saveBeneficiary(beneficiary);
		}
		
		@GetMapping("/allBenificiary")
		public List<Beneficiary> getAllBeneficiary(){
			return benificiaryService.getAllBeneficiary();		
		}

		@GetMapping("/getBenificiaryById/{searchId}")
		public Beneficiary getBenificiaryById( @PathVariable long searchId) {
			return benificiaryService.getbenefiBeneficiarybyId(searchId); 
		}
			
		@DeleteMapping("/delete/{searchId}")
		public void deleteBenificiaryById(@PathVariable long searchId) {
			benificiaryService.deletebenefiBeneficiarybyId(searchId);				
		}       
		
}
