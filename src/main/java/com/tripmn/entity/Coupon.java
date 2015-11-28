package com.tripmn.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tripmn.enums.CouponStatus;

@Entity
public class Coupon extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	

	private String couponType;

	private long amount;

	private String couponCode;

	private Date expiryDate;

	private CouponStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public CouponStatus getStatus() {
		return status;
	}

	public void setStatus(CouponStatus status) {
		this.status = status;
	}
}
