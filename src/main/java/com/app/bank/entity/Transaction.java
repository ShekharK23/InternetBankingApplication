package com.app.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionNumber;
	private String transactionDate;
	private int transactionAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private Account account;
	
}
