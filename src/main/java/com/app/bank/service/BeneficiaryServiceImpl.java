package com.app.bank.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.Beneficiary;
import com.app.bank.repository.IBeneficiaryRepository;

@Service
public class BeneficiaryServiceImpl implements IBeneficiaryService {
	@Autowired
	IBeneficiaryRepository beneficiaryRepository;

	@Override
	public long saveBeneficiary(Beneficiary beneficiary) {
		Beneficiary savedBeneficiary=beneficiaryRepository.save(beneficiary);
		long benCode=savedBeneficiary.getBeneficiaryAccountNumber();
		return benCode;
	}

	@Override
	public List<Beneficiary> getAllBeneficiary() {
		List<Beneficiary> allBeneficiary = beneficiaryRepository.findAll();
		return allBeneficiary;
	}

	@Override
	public Beneficiary getbenefiBeneficiarybyId(long searchId) {
	    Beneficiary b = beneficiaryRepository.findById(searchId).get();
		return b;
	}

	@Override
	public void deletebenefiBeneficiarybyId(long searchId) {
		beneficiaryRepository.deleteById(searchId);
	}

}
