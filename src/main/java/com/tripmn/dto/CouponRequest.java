package com.tripmn.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CouponRequest", propOrder = {}, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class CouponRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

 }
