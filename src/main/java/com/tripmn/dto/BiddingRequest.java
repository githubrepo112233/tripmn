package com.tripmn.dto;

public class BiddingRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	private long userId;
	private long itemId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
}
