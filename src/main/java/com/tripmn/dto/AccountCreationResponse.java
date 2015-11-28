package com.tripmn.dto;

import com.tripmn.enums.AccountStatus;

public class AccountCreationResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private long accountId;
	private AccountStatus status;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

}