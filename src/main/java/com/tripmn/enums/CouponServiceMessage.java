package com.tripmn.enums;

public enum CouponServiceMessage implements PlatformErrorInterface {
	
	COUPONS_NOT_AVAILABLE(700701, "COUPONS_NOT_AVAILABLE", "Coupons not available.");
	
	private int code;
	private String strCode;
	private String descrtipion;
	
	private CouponServiceMessage(int code, String strCode, String description){
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
