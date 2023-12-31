package com.app.bank.entity;

import java.time.LocalDate; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.bank.util.TransactionDateConvertor;

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
	private String transactionDate=	TransactionDateConvertor.convertCurrentDateToString("yyyy-MM-dd");
	private int transactionAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionNumber1")
	private Account account;
	
}
