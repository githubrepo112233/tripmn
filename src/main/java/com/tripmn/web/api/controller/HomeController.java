package com.tripmn.web.api.controller;

import java.util.Date;
import java.util.List;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tripmn.dto.UserDto;
import com.tripmn.entity.User;
import com.tripmn.repository.UserRepository;
import com.tripmn.service.impl.UserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepositry;
	
	@Autowired
	private Mapper mapper;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	@RequestMapping("/test")
	@Transactional
	public @ResponseBody String home(){
		System.out.println(userRepositry.findById(1L, false));
		System.out.println(userRepositry.count());
		System.out.println(userRepositry.findAll());
		User u = new User();
		u.setCreationTime(new Date());
		u.setEmailId("mahesh@wavecrest.gi");
		u.setFirstName("Mahesh");
		u.setLastName("Reddy");
		u.setCreatorId("King");
		UserDto userDto = mapper.map(u, UserDto.class);
		System.out.println(userDto);
		
		List<User> userList = (List<User>) userRepositry.findAll();
		for(User user : userList){
			System.out.println(mapper.map(user, UserDto.class));
		}
		//userRepositry.save(u);
		User u2 = userRepositry.findByEmailId("mahesh@wavecrest.gi2");
		System.out.println(u2);
		return "test";
	}
}
