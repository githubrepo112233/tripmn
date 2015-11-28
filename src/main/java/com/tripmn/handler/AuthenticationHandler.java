package com.tripmn.handler;

import com.tripmn.dto.AuthenticationRequest;
import com.tripmn.dto.AuthenticationResponse;

public interface AuthenticationHandler {
	public AuthenticationResponse authenticate(
			AuthenticationRequest userValidationRequest);
}