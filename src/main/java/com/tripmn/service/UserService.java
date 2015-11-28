package com.tripmn.service;

import com.tripmn.dto.AuthenticationRequest;
import com.tripmn.dto.AuthenticationResponse;
import com.tripmn.dto.UserRegistrationRequest;
import com.tripmn.dto.UserRegistrationResponse;

public interface UserService {

	public UserRegistrationResponse registerUser(
			UserRegistrationRequest userRegistrationRequest);

	public AuthenticationResponse authenticate(
			AuthenticationRequest authenticationRequest);

}
