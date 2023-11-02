package com.app.bank.service;

import org.springframework.stereotype.Service;

import com.app.bank.entity.DebitCard;

@Service
public interface IDebitCardService {
	public long saveDebitCardDetails(DebitCard debitCard);
	public DebitCard getDebitCardByDebitCardNumber(long debitCardNumber);
	
	public DebitCard changePin(long debitCardNumber, int newPin);
	public DebitCard requestNewCard(long debitCardNumber);
	public String checkExpiry(long debitCardNumber);
	
	
}