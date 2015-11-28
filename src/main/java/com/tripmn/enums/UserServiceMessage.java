package com.tripmn.enums;

public enum UserServiceMessage implements PlatformErrorInterface {
	
	EMAIL_ADDRESS_REQUIRED(700101, "EMAIL_ADDRESS_REQUIRED", "Email not available in the request."),
	MOBILE_NUMBER_REQUIRED(700102, "MOBILE_NUMBER_REQUIRED", "Mobile Number not available in the request."),
	USER_NAME_REQUIRED(700103, "USER_NAME_REQUIRED", "Username not available in the request."),
	USER_TYPE_REQUIRED(700104, "USER_NAME_REQUIRED", "UserType not available in the quest."),
	INVALID_EMAIL_FORMAT(700105, "INVALID_EMAIL_FORMAT", "Email is not in proper format."),
	DUPLIATE_MOBILE_NUMBER(700112, "DUPLIATE_MOBILE_NUMBER", "Mobile Number already available,please choose a different Mobile Number."),
	OTP_REQUIRED(700201, "OTP_REQUIRED", "OTP not available in Request."),
	INVALID_OTP(700201, "INVALID_OTP", "Invalid OTP."),
	INVALID_USER_ID(700209, "INVALID_USER_ID", "Invalid userId in the request.");
	
	private int code;
	private String strCode;
	private String descrtipion;
	
	private UserServiceMessage(int code, String strCode, String description){
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
