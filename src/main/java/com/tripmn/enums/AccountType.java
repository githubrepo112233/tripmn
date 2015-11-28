package com.tripmn.enums;

public enum AccountType implements PlatformEnumInterface {
	Loyalty(0, "Loyalty"),
	Emoney(1, "Emoney"),
	RemoteEmoney(2, "RemoteEmoney"),
	Token(1, "Token");
	
	private int value;
	private String description;
	
	private AccountType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	@Override
	public int value() {
		return this.value;
	}

	@Override
	public String description() {
		return this.description;
	}

}
