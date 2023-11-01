package com.app.bank.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAddDTO {

	private String accountHolderName;
	private int accountHolderAge;
	private int accountBalance;
	private String panNumber;
	private String accountType;
	
}
