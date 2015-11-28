package com.tripmn.dto;

public class ValidationCheck {

	private int errorCode;
	private String erroDescription;
	boolean isInvalid;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErroDescription() {
		return erroDescription;
	}

	public void setErroDescription(String erroDescription) {
		this.erroDescription = erroDescription;
	}

	public boolean isInvalid() {
		return isInvalid;
	}

	public void setInvalid(boolean isInvalid) {
		this.isInvalid = isInvalid;
	}
}
