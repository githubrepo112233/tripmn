package com.tripmn.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tripmn.enums.PlatformMessage;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponse", propOrder = { "errorCode", "errorDescription" }, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BaseResponse() {
		this.errorCode = PlatformMessage.SUCCESS.getCode();
		this.errorDescription = PlatformMessage.SUCCESS.getDescription();
	}

	private int errorCode;
	private String errorDescription;

	@JsonIgnore
	@XmlTransient
	private Map<String, Object> varMap;

	@JsonIgnore
	@XmlTransient
	private List<String> varList;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Map<String, Object> getVarMap() {
		return varMap;
	}

	public void setVarMap(Map<String, Object> varMap) {
		this.varMap = varMap;
	}

	public List<String> getVarList() {
		return varList;
	}

	public void setVarList(List<String> varList) {
		this.varList = varList;
	}
}
