package com.tripmn.enums;


public enum ItemServiceMessage implements PlatformErrorInterface {
	
	TOKENS_NOT_AVAILABLE(700301, "TOKENS_NOT_AVAILABLE", "Tokens not available."),
	ITEMS_NOT_AVAILABLE(700401, "ITEMS_NOT_AVAILABLE", "Items not available."),
	INVALID_SESSION(700002, "INVALID_SESSION", "Invalid session.");
	
	private int code;
	private String strCode;
	private String descrtipion;
	
	private ItemServiceMessage(int code, String strCode, String description){
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