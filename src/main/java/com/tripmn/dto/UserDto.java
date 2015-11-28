package com.tripmn.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequest", propOrder = { "firstName", "lastName",
		"mobileNumber", "emailId" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "firstName :" + firstName + " lastName : " + lastName
				+ " mobileNumber : " + mobileNumber + " emailId : " + emailId;
	}
}
