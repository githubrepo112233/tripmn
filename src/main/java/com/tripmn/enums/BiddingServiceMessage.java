package com.tripmn.enums;

public enum BiddingServiceMessage implements PlatformErrorInterface {

	NO_BIDDING_IN_PROGRESS(110001, "NO_BIDDING_IN_PROGRESS", "No bidding is in progress for selected item"),
	BIDDING_EXPIRED(110002, "BIDDING_EXPIRED", "Bidding has been expired"),
	USER_ALREDY_WINNING(110003, "USER_ALREDY_WINNING", "Requesting user is already in winning state");

	private int code;
	private String strCode;
	private String descrtipion;

	BiddingServiceMessage(int code, String strCode, String description) {
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
