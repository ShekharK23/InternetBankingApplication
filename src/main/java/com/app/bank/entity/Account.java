package com.app.bank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	private String accountHolderName;
	private int accountHolderAge;
	private int accountBalance;
	private String panNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "debitCardNumber")
	private DebitCard debitCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creditCardNumber")
	private CreditCard creditCard;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyNumber")
	private List<Policy> allPolicy;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fdNumber")
	private List<Investment> allInvestment;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "beneficiaryAccountNumber")
	private List<Beneficiary> allBeneficiary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionNumber1")
	private List<Transaction> allTransactions;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branchIFSC")
	private Branch branch;
}
