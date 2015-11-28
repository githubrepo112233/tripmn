package com.tripmn.dto;

import java.util.List;

public class FetchItemsResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private List<ItemDTO> itemList;

	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}
}
