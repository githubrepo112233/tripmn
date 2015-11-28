package com.tripmn.dto;

public class AuthenticationRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private long userId;
	private String otp;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}
