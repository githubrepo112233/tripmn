package com.tripmn.dto;

public class AuthenticationResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private boolean isAuthenticated;
	private String authenticationToken;

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
}
