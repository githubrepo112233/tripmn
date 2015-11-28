package com.tripmn.dto;

import java.io.Serializable;
import java.util.Date;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;

	private String name;

	private String description;

	private String brand;

	private long price;

	private Date endDate;

	private String imagePath;

	private String termsAndConditions;

	private boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
