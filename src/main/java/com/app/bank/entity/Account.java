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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about Account Bean")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Unique Account Number of Account")
	private long accountNumber;
	@ApiModelProperty(notes = "Name of Account Holder")
	private String accountHolderName;
	private int accountHolderAge;
	private int accountBalance;
	private String panNumber;
	@ApiModelProperty(notes = "Type of Account - Salaried, Savings, Current")
	private String accountType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "debitCardNumber")
	private DebitCard debitCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creditCardNumber")
	private CreditCard creditCard;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyNumber1")
	private List<Policy> allPolicy;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fdNumber1")
	private List<Investment> allInvestment;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "beneficiaryAccountNumber")
	private List<Beneficiary> allBeneficiary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionNumber1")
	private List<Transaction> allTransactions;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branchIFSC1")
	private Branch branch;
}
