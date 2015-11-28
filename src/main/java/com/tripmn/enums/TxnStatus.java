package com.tripmn.enums;

public enum TxnStatus implements PlatformEnumInterface {
	
	Pending(0, "Pending"),
	Failed(1, "Failed"),
	Success(2, "Success");
	
	private int value;
	private String description;
	
	private TxnStatus(int value, String description) {
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
