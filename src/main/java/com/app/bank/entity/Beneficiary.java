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
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryBankName;
	private String benificiaryIFSCCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumberB")
	private Account account;
	
}
