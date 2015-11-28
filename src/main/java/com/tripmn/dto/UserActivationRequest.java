package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OTPValidationRequest", propOrder = { "otp", "userId" }, namespace = "http://www.tripmn.com")
public class UserActivationRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private String otp;
	private long userId;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
