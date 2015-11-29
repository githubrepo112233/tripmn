package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserFetchProfileResponse", propOrder = { "userName", "emailId", "mobileNumber",
		"image", "address", "status", "userType", "availableBalance", "cumulativeBalance" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class UserFetchProfileResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private long userName;
	private long emailId;
	private long mobileNumber;
	private long image;
	private long address;
	private long status;
	private long userType;
	private long availableBalance;
	private long cumulativeBalance;
	public long getUserName() {
		return userName;
	}
	public void setUserName(long userName) {
		this.userName = userName;
	}
	public long getEmailId() {
		return emailId;
	}
	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getImage() {
		return image;
	}
	public void setImage(long image) {
		this.image = image;
	}
	public long getAddress() {
		return address;
	}
	public void setAddress(long address) {
		this.address = address;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public long getUserType() {
		return userType;
	}
	public void setUserType(long userType) {
		this.userType = userType;
	}
	public long getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}
	public long getCumulativeBalance() {
		return cumulativeBalance;
	}
	public void setCumulativeBalance(long cumulativeBalance) {
		this.cumulativeBalance = cumulativeBalance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
