package com.app.bank.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.entity.CreditCard;
import com.app.bank.repository.ICreditCardRepository;

import com.app.bank.util.DateConverter;
@Service

public class CreditCardServiceImpl implements ICreditCardService {

	@Autowired
	ICreditCardRepository creditCardRepository;

	@Override
	public long saveCreditCardDetails(CreditCard creditCard) {
		CreditCard savedCreditCard = creditCardRepository.save(creditCard);
		if(savedCreditCard != null) {
			long newCreditCardNumber = savedCreditCard.getCreditCardNumber();
			return newCreditCardNumber;
		}
		return 0;
	}

	@Override
	public CreditCard getCreditCardByCreditCardNumber(long creditCardNumber) {
		CreditCard savedCreditCard = creditCardRepository.findById(creditCardNumber).get();
		return savedCreditCard;
	}

	@Override
	@Transactional
	public CreditCard changePin(long creditCardNumber, int newPin) {
		CreditCard savedCreditCard = getCreditCardByCreditCardNumber(creditCardNumber);
		if(savedCreditCard != null) {
			savedCreditCard.setCreditCardPin(newPin);
			return savedCreditCard;
		}
		return null;
	}

//	@Override
//	@Transactional
//	public DebitCard blockCard(long debitCardNumber, String cardStatus) {
//		DebitCard savedDebitCard = getDebitCardByDebitCardNumber(debitCardNumber);
//		if(savedDebitCard!=null) {
//			savedDebitCard.setDebitCardStatus(cardStatus);
//			if(cardStatus.equalsIgnoreCase("Not Allocated")) {
//				savedDebitCard.setDebitCardStatus(cardStatus);
//			}
//			return savedDebitCard;
//		}
//		return null;
//	}


	  @Override
	  public String checkExpiry(long creditCardNumber) {
	        CreditCard savedDebitCard = getCreditCardByCreditCardNumber(creditCardNumber);
	        if (savedDebitCard != null) {
	            LocalDate currentDate = LocalDate.now();
	            String expiryDateString = savedDebitCard.getCreditCardExpiryDate();
	            
	            LocalDate expiryDate = DateConverter.getDateFromString(expiryDateString);
	            
	            if (expiryDate != null && currentDate.isAfter(expiryDate) ) {
	                return "Debit Card is Expired";
	            }
	            return "Debit Card is Yet To Expired";
	        }
	        return "Debit Card Not Allocated";
	    }

	@Override
	public CreditCard requestNewCard(long creditCardNumber) {
		CreditCard savedCreditCard = getCreditCardByCreditCardNumber(creditCardNumber);
		if(savedCreditCard!=null) {
			
		}
		return null;
	}

	  
	  
//	
}



