package com.tripmn.service.impl;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tripmn.dto.AccountCreationRequest;
import com.tripmn.dto.AccountCreationResponse;
import com.tripmn.dto.AuthenticationRequest;
import com.tripmn.dto.AuthenticationResponse;
import com.tripmn.dto.UserRegistrationRequest;
import com.tripmn.dto.UserRegistrationResponse;
import com.tripmn.dto.ValidationCheck;
import com.tripmn.entity.User;
import com.tripmn.enums.AccountType;
import com.tripmn.enums.UserServiceMessage;
import com.tripmn.enums.UserStatus;
import com.tripmn.enums.UserType;
import com.tripmn.handler.AuthenticationHandler;
import com.tripmn.repository.AccountRepository;
import com.tripmn.repository.UserRepository;
import com.tripmn.service.TransactionService;
import com.tripmn.service.UserService;
import com.tripmn.utils.PlatformUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationHandler authenticationHandler;

	@Autowired
	private Mapper mapper;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional
	public UserRegistrationResponse registerUser(
			UserRegistrationRequest userRegistrationRequest) {
		logger.info("{}{}", "registering the user, registrationRequest :",
				userRegistrationRequest.toString());

		UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
		ValidationCheck validationCheck = validateUser(userRegistrationRequest);
		if (validationCheck.isInvalid()) {
			PlatformUtils.addError(userRegistrationResponse,
					validationCheck.getErrorCode(),
					validationCheck.getErroDescription());
			return userRegistrationResponse;
		}
		User user = mapper.map(userRegistrationRequest, User.class);
		user.setStatus(UserStatus.Unverified);
		user = userRepository.makePersistent(user);
		userRegistrationResponse.setUserId(user.getId());
		userRegistrationResponse.setBalance(500L);

		return userRegistrationResponse;
	}

	@Override
	@Transactional
	public AuthenticationResponse authenticate(
			AuthenticationRequest authenticationRequest) {

		AuthenticationResponse response = new AuthenticationResponse();

		if (!userRepository.exists(authenticationRequest.getUserId())) {
			PlatformUtils
					.addError(response, UserServiceMessage.INVALID_USER_ID);
			return response;
		}

		User user = userRepository.findById(authenticationRequest.getUserId(),
				true);

		if (user == null) {
			PlatformUtils
					.addError(response, UserServiceMessage.INVALID_USER_ID);
			return response;
		}
		response = authenticationHandler.authenticate(authenticationRequest);

		if (response.isAuthenticated()) {
			user.setStatus(UserStatus.Active);
			AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
			accountCreationRequest.setAccountType(AccountType.Token);
			accountCreationRequest.setUserId(user.getId());
			AccountCreationResponse accountCreationResponse = transactionService
					.createAccount(accountCreationRequest);
			if (!PlatformUtils.isSuccess(accountCreationResponse)) {
				PlatformUtils.addError(response, accountCreationResponse);
				return response;
			}
			userRepository.merge(user);
		}
		return response;
	}
	
	private ValidationCheck validateUser(UserRegistrationRequest userRegistrationRequest){
		
		ValidationCheck validationCheck = new ValidationCheck();
		validationCheck.setInvalid(false);
		validationCheck.setErrorCode(0);
		
		String uname=userRegistrationRequest.getUserName().trim();
		String email=userRegistrationRequest.getEmailId().trim();
		String mobno=userRegistrationRequest.getMobileNumber().trim();
		UserType userType=userRegistrationRequest.getUserType();
		boolean userTypeBool=userRegistrationRequest.getUserType().equals(UserType.Customer);
		
		
		if((uname==null||uname.equals(""))&&(email==null||email.equals(""))&&(mobno==null||mobno.equals(""))&&
				userType==null){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.REG_DETAILS_REQUIRED.getCode());
			validationCheck.setErroDescription(UserServiceMessage.REG_DETAILS_REQUIRED.getDescription());
		}else if(uname==null||uname.equals("")){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.USER_NAME_REQUIRED.getCode());
			validationCheck.setErroDescription(UserServiceMessage.USER_NAME_REQUIRED.getDescription());
		}else if(email==null||email.equals("")){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.EMAIL_ADDRESS_REQUIRED.getCode());
			validationCheck.setErroDescription(UserServiceMessage.EMAIL_ADDRESS_REQUIRED.getDescription());
		}else if(mobno==null||mobno.equals("")){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.MOBILE_NUMBER_REQUIRED.getCode());
			validationCheck.setErroDescription(UserServiceMessage.MOBILE_NUMBER_REQUIRED.getDescription());
		}else if(userType==null||userType.equals("")){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.USER_TYPE_REQUIRED.getCode());
			validationCheck.setErroDescription(UserServiceMessage.USER_TYPE_REQUIRED.getDescription());
		}else if(!email.contains("@")){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.INVALID_EMAIL_FORMAT.getCode());
			validationCheck.setErroDescription(UserServiceMessage.INVALID_EMAIL_FORMAT.getDescription());
		}else if(mobno.length()!=10){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.INVALID_MOBILE_NO_FORMAT.getCode());
			validationCheck.setErroDescription(UserServiceMessage.INVALID_MOBILE_NO_FORMAT.getDescription());
		}else if(!userTypeBool){
			validationCheck.setInvalid(true);
			validationCheck.setErrorCode(UserServiceMessage.INVALID_USER_TYPE.getCode());
			validationCheck.setErroDescription(UserServiceMessage.INVALID_USER_TYPE.getDescription());
		}else{
			try{
				User user = userRepository.findByMobileNumber(userRegistrationRequest.getMobileNumber());
				if(user != null && !validationCheck.isInvalid()){
					validationCheck.setInvalid(true);
					validationCheck.setErrorCode(UserServiceMessage.DUPLICATE_MOBILE_NUMBER.getCode());
					validationCheck.setErroDescription(UserServiceMessage.DUPLICATE_MOBILE_NUMBER.getDescription());
				}else if(userRepository.findByUserName(userRegistrationRequest.getUserName())!=null && !validationCheck.isInvalid()){
					validationCheck.setInvalid(true);
					validationCheck.setErrorCode(UserServiceMessage.DUPLICATE_USER_NAME.getCode());
					validationCheck.setErroDescription(UserServiceMessage.DUPLICATE_USER_NAME.getDescription());
				}else if(userRepository.findByEmailId(userRegistrationRequest.getEmailId())!=null && !validationCheck.isInvalid()){
					validationCheck.setInvalid(true);
					validationCheck.setErrorCode(UserServiceMessage.DUPLICATE_EMAIL.getCode());
					validationCheck.setErroDescription(UserServiceMessage.DUPLICATE_EMAIL.getDescription());
				}
		     }catch(Exception e){
				  validationCheck.setInvalid(true);
				  validationCheck.setErrorCode(UserServiceMessage.COMM_ERROR.getCode());
				  validationCheck.setErroDescription(UserServiceMessage.COMM_ERROR.getDescription());
		  }
		}
		return validationCheck;
	}
}