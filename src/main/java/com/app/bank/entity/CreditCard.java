package com.app.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long creditCardNumber;
	private int creditCardPin;
	private String creditCardExpiryDate;
	private int creditCardLimit;
	
	
	private String creditCardStatus;
	
}
