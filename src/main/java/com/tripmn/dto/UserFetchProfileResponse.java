package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tripmn.enums.UserStatus;
import com.tripmn.enums.UserType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserFetchProfileResponse", propOrder = { "userName", "emailId", "mobileNumber",
		"image", "address", "status", "userType", "availableBalance", "cumulativeBalance" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class UserFetchProfileResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String emailId;
	private long mobileNumber;
	private String image;
	private String address;
	private UserStatus status;
	private UserType userType;
	private long availableBalance;
	private long cumulativeBalance;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
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
