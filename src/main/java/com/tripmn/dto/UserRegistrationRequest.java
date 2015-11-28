package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tripmn.enums.UserType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserRegistrationRequest", propOrder = { "userName", "emailId",
		"mobileNumber", "userType" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class UserRegistrationRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private UserType userType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
