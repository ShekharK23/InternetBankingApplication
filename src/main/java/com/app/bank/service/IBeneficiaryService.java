package com.app.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.bank.entity.Beneficiary;

@Service
public interface IBeneficiaryService {
	
	public long saveBeneficiary(Beneficiary beneficiary) ;
	public List<Beneficiary> getAllBeneficiary();
	public Beneficiary getbenefiBeneficiarybyId(long searchId);
	public void deletebenefiBeneficiarybyId(long searchId);
	
}