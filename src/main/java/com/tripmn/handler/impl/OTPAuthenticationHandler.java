package com.tripmn.handler.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tripmn.dto.AuthenticationRequest;
import com.tripmn.dto.AuthenticationResponse;
import com.tripmn.enums.UserServiceMessage;
import com.tripmn.handler.AuthenticationHandler;
import com.tripmn.utils.PlatformUtils;

@Service("authenticationHandler")
public class OTPAuthenticationHandler implements AuthenticationHandler {

	@Override
	public AuthenticationResponse authenticate(
			AuthenticationRequest authenticationRequest) {

		AuthenticationResponse response = new AuthenticationResponse();
		
		if(StringUtils.isBlank(authenticationRequest.getOtp())){
			PlatformUtils.addError(response, UserServiceMessage.OTP_REQUIRED);
			return response;
		}
		
		response.setAuthenticated(true);
		response.setAuthenticationToken(UUID.randomUUID().toString());
		
		return response;
	}

}
