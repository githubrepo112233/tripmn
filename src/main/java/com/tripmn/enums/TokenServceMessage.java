package com.tripmn.enums;

public enum TokenServceMessage implements PlatformErrorInterface {
	
	TOKENS_NOT_AVAILABLE(70001, "TOKENS_NOT_AVAILABLE", "Tokens not available."),
	ITEMS_NOT_AVAILABLE(700401, "ITEMS_NOT_AVAILABLE", "Items not available.");
	
	private int code;
	private String strCode;
	private String descrtipion;
	
	private TokenServceMessage(int code, String strCode, String description){
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
