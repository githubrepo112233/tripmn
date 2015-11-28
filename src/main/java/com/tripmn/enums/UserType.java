package com.tripmn.enums;

public enum UserType implements PlatformEnumInterface {
	AdminUser(0, "AdminUser"),
	Customer(1, "Customer");
	
	private int value;
	private String description;
	
	private UserType(int value, String description) {
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
