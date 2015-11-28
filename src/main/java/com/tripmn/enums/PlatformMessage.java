package com.tripmn.enums;

public enum PlatformMessage implements PlatformErrorInterface{
	
	SUCCESS(0, "SUCCESS", "Success"),
	GENERIC_ERROR(-100, "GENERIC_ERROR", "Generic Error"),
	INVALID_REQUEST(-101, "INVALID_REQUEST", "Invalid Request");
	
	private int code;
	private String strCode;
	private String descrtipion;
	
	PlatformMessage(int code, String strCode, String description){
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
