package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserRegistrationResponse", propOrder = { "userId", "balance" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class UserRegistrationResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	private long userId;
	private long balance;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
}
