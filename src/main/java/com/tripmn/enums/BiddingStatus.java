package com.tripmn.enums;

public enum BiddingStatus implements PlatformEnumInterface {

	Active(0, "Active"),
	Inactive(1, "Inactive"),
	Completed(2, "Completed");

	private int value;
	private String description;

	private BiddingStatus(int value, String description) {
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
