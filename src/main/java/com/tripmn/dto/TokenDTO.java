package com.tripmn.dto;

import java.io.Serializable;
import java.util.Date;

public class TokenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private long tokenQuantity;
	
	private long amount;

	private Date expirtyDate;

	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTokenQuantity() {
		return tokenQuantity;
	}

	public void setTokenQuantity(long tokenQuantity) {
		this.tokenQuantity = tokenQuantity;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getExpirtyDate() {
		return expirtyDate;
	}

	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
