package com.tripmn.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tripmn.dto.AuthenticationRequest;
import com.tripmn.dto.AuthenticationResponse;
import com.tripmn.dto.FetchItemsResponse;
import com.tripmn.dto.FetchTokensResponse;
import com.tripmn.dto.UserRegistrationRequest;
import com.tripmn.dto.UserRegistrationResponse;
import com.tripmn.service.ItemService;
import com.tripmn.service.TokenService;
import com.tripmn.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/registerUser")
	public @ResponseBody UserRegistrationResponse registerUser(
			@RequestBody UserRegistrationRequest userRegistrationRequest) {

		return userService.registerUser(userRegistrationRequest);
	}

	@RequestMapping("/validateotp")
	public @ResponseBody AuthenticationResponse authenticate(
			@RequestBody AuthenticationRequest authenticationRequest) {
		
		return userService.authenticate(authenticationRequest);
	}
	
	@RequestMapping("/fetchTokens")
	public @ResponseBody FetchTokensResponse fetchTokens(){
		return tokenService.fetchAllTokens();
	}
	
	@RequestMapping("/fetchItems")
	public @ResponseBody FetchItemsResponse fetchItems(){
		return itemService.fetchItems();
	}
}
