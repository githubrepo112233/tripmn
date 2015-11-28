package com.tripmn.dto;

import com.tripmn.enums.AccountType;

public class AccountCreationRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private long userId;
	private AccountType accountType;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
