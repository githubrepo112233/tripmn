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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequest", propOrder = { "credentails"}, namespace = "http://www.tripmn.com")
@JsonInclude(value=Include.NON_NULL)
public class BaseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Credentails credentails;

	@XmlTransient
	@JsonIgnore
	private Map<String, Object> varMap;

	@XmlTransient
	@JsonIgnore
	private List<String> varList;
	
	public Credentails getCredentails() {
		return credentails;
	}

	public void setCredentails(Credentails credentails) {
		this.credentails = credentails;
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
