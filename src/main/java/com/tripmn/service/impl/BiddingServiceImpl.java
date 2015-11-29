package com.tripmn.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmn.dto.BiddingRequest;
import com.tripmn.dto.BiddingResponse;
import com.tripmn.dto.TransactionRequest;
import com.tripmn.dto.TransactionResponse;
import com.tripmn.entity.Account;
import com.tripmn.entity.Item;
import com.tripmn.entity.ItemBidding;
import com.tripmn.entity.User;
import com.tripmn.enums.AccountType;
import com.tripmn.enums.BiddingServiceMessage;
import com.tripmn.enums.BiddingStatus;
import com.tripmn.enums.PlatformMessage;
import com.tripmn.enums.TransactionServiceMessage;
import com.tripmn.enums.TxnStatus;
import com.tripmn.enums.UserServiceMessage;
import com.tripmn.enums.UserStatus;
import com.tripmn.repository.AccountRepository;
import com.tripmn.repository.ItemBiddingRepository;
import com.tripmn.repository.ItemRepository;
import com.tripmn.repository.UserRepository;
import com.tripmn.service.BiddingService;
import com.tripmn.service.TransactionService;
import com.tripmn.utils.PlatformUtils;

@Service("biddingService")
public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemBiddingRepository itemBiddingRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	@Transactional
	public BiddingResponse bidItem(BiddingRequest biddingRequest) {
		
		BiddingResponse response = new BiddingResponse();
		
		if(biddingRequest == null){
			PlatformUtils.addError(response, PlatformMessage.INVALID_REQUEST);
			return response;
		}
		
		Item item = itemRepository.findOne(biddingRequest.getItemId());
		if(item == null){
			PlatformUtils.addError(response, PlatformMessage.INVALID_REQUEST);
			return response;
		}
		
		ItemBidding itemBidding = itemBiddingRepository.findByItemAndStatus(item, BiddingStatus.Active);
		if(itemBidding == null){
			PlatformUtils.addError(response, BiddingServiceMessage.NO_BIDDING_IN_PROGRESS);
			return response;
		}
		itemBidding = itemBiddingRepository.findById(itemBidding.getId(), true);
		long biddingExpirySeconds = PlatformUtils.dateDiffSeconds(new Date(), itemBidding.getEndDate());
		if(biddingExpirySeconds <= 0){
			itemBidding.setStatus(BiddingStatus.Completed);
			itemBiddingRepository.merge(itemBidding);
			PlatformUtils.addError(response, BiddingServiceMessage.BIDDING_EXPIRED);
			return response;
		}
		
		if (itemBidding.getWinningUser() != null
				&& itemBidding.getWinningUser().getId() == biddingRequest.getUserId()) {
			PlatformUtils.addError(response,BiddingServiceMessage.USER_ALREDY_WINNING);
			return response;
		}
		
		TransactionRequest txnRequest = new TransactionRequest();
		User user = userRepository.findById(biddingRequest.getUserId(), true);
		if(user == null){
			PlatformUtils.addError(response, UserServiceMessage.INVALID_USER_ID);
			return response;
		}
		if(!user.getStatus().equals(UserStatus.Active)){
			PlatformUtils.addError(response, UserServiceMessage.USER_NOT_ACTIVE);
			return response;
		}
		Account account = accountRepository.findByUserAndAccountType(user, AccountType.Token);
		if(account == null){
			PlatformUtils.addError(response, TransactionServiceMessage.INVALID_ACCOUNT_ID);
			return response;
		}
		txnRequest.setAccountId(account.getId());
		txnRequest.setAmount(1);
		txnRequest.setComments("Bidding");
		txnRequest.setCrDrInd((short) -1);
		txnRequest.setUserId(biddingRequest.getUserId());
		txnRequest.setTxnStatus(TxnStatus.Success);
		txnRequest.setSettleType((short)3);
		TransactionResponse txnResponse = transactionService.debit(txnRequest);
		if(!PlatformUtils.isSuccess(txnResponse)){
			response.setErrorCode(txnResponse.getErrorCode());
			response.setErrorDescription(txnResponse.getErrorDescription());
			return response;
		}
		if(biddingExpirySeconds <= 5){
			int graceSeconds = (int)(15 - biddingExpirySeconds);
			itemBidding.setEndDate(DateUtils.addSeconds(itemBidding.getEndDate(), graceSeconds));
			itemBidding.setGraceSeconds(itemBidding.getGraceSeconds() + graceSeconds);
		}
		itemBidding.setBiddingTokens(itemBidding.getBiddingTokens() + txnRequest.getAmount());
		itemBidding.setWinningUser(user);
		itemBiddingRepository.merge(itemBidding);
		
		return response;
	}
}
