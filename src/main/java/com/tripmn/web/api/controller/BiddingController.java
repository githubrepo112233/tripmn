package com.tripmn.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tripmn.dto.BiddingRequest;
import com.tripmn.dto.BiddingResponse;
import com.tripmn.service.BiddingService;

@Controller
public class BiddingController {
	
	@Autowired
	private BiddingService biddingService;
	
	@RequestMapping("/bidItem")
	public @ResponseBody BiddingResponse bidItem(@RequestBody BiddingRequest biddingRequest){
		BiddingResponse response = biddingService.bidItem(biddingRequest);
		return response;
	}
}
