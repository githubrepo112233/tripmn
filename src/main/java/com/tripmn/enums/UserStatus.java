package com.tripmn.enums;

public enum UserStatus implements PlatformEnumInterface {
	Active(0, "Active"),
	Blocked(1, "Blocked"),
	Suspended(2, "Suspended"),
	Unverified(3, "Unverified");
	
	private int value;
	private String description;
	
	private UserStatus(int value, String description) {
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
