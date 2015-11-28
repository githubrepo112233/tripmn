package com.tripmn.enums;

public enum TransactionServiceMessage implements PlatformErrorInterface {

	INVALID_ACCOUNT_ID(9001, "INVALID_ACCOUNT_ID", "Invalid account"),
	INSUFFICIENT_BALANCE(9002, "INSUFFICIENT_BALANCE", "Insufficient Balance in the account"),
	INVALID_TRANSACTION_ID(9003, "INVALID_TRANSACTION_ID", "Invalid transaction id");

	private int code;
	private String strCode;
	private String descrtipion;

	TransactionServiceMessage(int code, String strCode, String description) {
		this.code = code;
		this.strCode = strCode;
		this.descrtipion = description;
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getStrCode() {
		return this.strCode;
	}

	@Override
	public String getDescription() {
		return this.descrtipion;
	}
}
