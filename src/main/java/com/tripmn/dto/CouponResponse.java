package com.tripmn.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CouponResponse", propOrder = { "couponList" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class CouponResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	private List<CouponDTO> couponList;

	public List<CouponDTO> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<CouponDTO> couponList) {
		this.couponList = couponList;
	}
	
}
