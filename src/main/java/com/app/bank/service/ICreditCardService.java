package com.app.bank.service;

import org.springframework.stereotype.Service;

import com.app.bank.entity.CreditCard;


@Service
public interface ICreditCardService {
	public long saveCreditCardDetails(CreditCard creditCard);
	public CreditCard getCreditCardByCreditCardNumber(long creditCardNumber);
	
	public CreditCard changePin(long creditCardNumber, int newPin);
	public CreditCard requestNewCard(long creditCardNumber);
	public String checkExpiry(long creditCardNumber);
	
	
}
