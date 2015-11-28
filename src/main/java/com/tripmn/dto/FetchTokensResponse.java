package com.tripmn.dto;

import java.util.List;

public class FetchTokensResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private List<TokenDTO> tokenList;

	public List<TokenDTO> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List<TokenDTO> tokenList) {
		this.tokenList = tokenList;
	}
}
