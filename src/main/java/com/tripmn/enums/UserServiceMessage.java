package com.tripmn.enums;

public enum UserServiceMessage implements PlatformErrorInterface {
	
	REG_DETAILS_REQUIRED(700101, "REG_DETAILS_REQUIRED", "Registration Details not available in the request."),
	EMAIL_ADDRESS_REQUIRED(700102, "EMAIL_ADDRESS_REQUIRED", "Email not available in the request."),
	MOBILE_NUMBER_REQUIRED(700103, "MOBILE_NUMBER_REQUIRED", "Mobile Number not available in the request."),
	USER_NAME_REQUIRED(700104, "USER_NAME_REQUIRED", "Username not available in the request."),
	USER_TYPE_REQUIRED(700105, "USER_TYPE_REQUIRED", "UserType not available in the request."),
	INVALID_EMAIL_FORMAT(700106, "INVALID_EMAIL_FORMAT", "Email is not in proper format."),
	INVALID_MOBILE_NO_FORMAT(700107, "INVALID_MOBILE_NO_FORMAT", "Please enter 10 digit Mobile Number."),
	USER_ALREADY_REGISTERED(700108, "USER_ALREADY_REGISTERED", "Already registered with the provided details."),
	INVALID_USER_TYPE(700109, "INVALID_USER_TYPE", "Invalid UserType."),
	DUPLICATE_USER_NAME(700110, "DUPLICATE_USER_NAME", "Username already available, please choose a different Username."),
	DUPLICATE_EMAIL(700111, "DUPLICATE_EMAIL", "Email already available, please choose a different Email."),
	DUPLICATE_MOBILE_NUMBER(700112, "DUPLICATE_MOBILE_NUMBER", "Mobile Number already available,please choose a different Mobile Number."),
	MAX_LENGTH_EXCEEDED_FOR_INPUT_PARAMS(700113, "MAX_LENGTH_EXCEEDED_FOR_INPUT_PARAMS", "Max Length exceeded for input parameters."),
	SQL_EXCEPTION(700001, "SQL_EXCEPTION", "SQL Exception from DB."),
	INVALID_SESSION(700002, "INVALID_SESSION", "Invalid session."),
	SESSION_EXPIRED(700003, "SESSION_EXPIRED", "Session expired."),
	COMM_ERROR(700004, "COMM_ERROR", "Communication error, please try after some time."),
	OTP_REQUIRED(700201, "OTP_REQUIRED", "OTP not available in Request."),
	INVALID_OTP(700202, "INVALID_OTP", "Invalid OTP."),
	USER_ID_REQUIRED(700203, "USER_ID_REQUIRED", "User Id not available in the request."),
	INVALID_USER_ID(700204, "INVALID_USER_ID", "Invalid userId in the request.");
	
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
