package com.tripmn.enums;

public enum AccountStatus implements PlatformEnumInterface {
	
	Active(0, "Active"),
	Blocked(1, "Blocked"),
	Suspended(2, "Suspended");
	
	private int value;
	private String description;
	
	private AccountStatus(int value, String description) {
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
