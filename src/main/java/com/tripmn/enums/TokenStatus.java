package com.tripmn.enums;

public enum TokenStatus implements PlatformEnumInterface {
	
	Active(0, "Active"),
	Inactive(1, "Inactive");
	
	private int value;
	private String description;
	
	private TokenStatus(int value, String description) {
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
