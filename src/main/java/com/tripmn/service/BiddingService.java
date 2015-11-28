package com.tripmn.service;

import com.tripmn.dto.BiddingRequest;
import com.tripmn.dto.BiddingResponse;

public interface BiddingService {
	
	public BiddingResponse bidItem(BiddingRequest biddingRequest);
	
}
