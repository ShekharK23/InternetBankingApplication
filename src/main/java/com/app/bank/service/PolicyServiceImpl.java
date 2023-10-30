package com.app.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.Policy;
import com.app.bank.repository.IPolicyRepository;

@Service
public class PolicyServiceImpl implements IPolicyService {
	
	@Autowired
	IPolicyRepository policyRepository;

	@Override
	public long savePolicy(Policy policy) {
		Policy savedPolicy = policyRepository.save(policy);
		if(savedPolicy != null)
			return savedPolicy.getPolicyNumber();
		return 0;
	}

	@Override
	public Policy getPolicyByPolicyNumber(long policyNumber) {
		Policy savedPolicy = policyRepository.findById(policyNumber).get();
		return savedPolicy;
	}

	@Override
	public List<Policy> getAllPolicies() {
		List<Policy> allPolicies = policyRepository.findAll();
		return allPolicies;
	}

	@Override
	@Transactional
	public Policy updatePremiumAmountOfPolicyByPolicyNumber(long policyNumber, int newPremiumAmount) {
		Policy savedPolicy = getPolicyByPolicyNumber(policyNumber);
		if(savedPolicy != null) {
			savedPolicy.setPolicyPremiumAmount(newPremiumAmount);
			return savedPolicy;
		}
		return null;
	}

	@Override
	public Policy checkExpiryDate(long policyNumber) {
		Policy savedPolicy = getPolicyByPolicyNumber(policyNumber);
		if(savedPolicy!=null) {
			
		}
		return null;
	}

}
