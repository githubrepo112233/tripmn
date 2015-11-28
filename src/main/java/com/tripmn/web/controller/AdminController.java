package com.tripmn.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tripmn.service.impl.UserServiceImpl;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@RequestMapping("/home")
	public String home(){
		logger.info("{}", "inside admin controller");
		return "index";
	}
}
