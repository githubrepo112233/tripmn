package com.tripmn.service;

import com.tripmn.dto.AccountCreationRequest;
import com.tripmn.dto.AccountCreationResponse;
import com.tripmn.dto.TransactionRequest;
import com.tripmn.dto.TransactionResponse;

public interface TransactionService {

	public TransactionResponse credit(TransactionRequest transactionRequest);

	public TransactionResponse debit(TransactionRequest transactionRequest);
	
	public AccountCreationResponse createAccount(AccountCreationRequest accountCreationRequest);

}