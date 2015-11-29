package com.tripmn.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmn.dto.AccountCreationRequest;
import com.tripmn.dto.AccountCreationResponse;
import com.tripmn.dto.TransactionRequest;
import com.tripmn.dto.TransactionResponse;
import com.tripmn.entity.Account;
import com.tripmn.entity.Transaction;
import com.tripmn.entity.User;
import com.tripmn.enums.AccountStatus;
import com.tripmn.enums.PlatformMessage;
import com.tripmn.enums.TransactionServiceMessage;
import com.tripmn.enums.TxnStatus;
import com.tripmn.enums.UserServiceMessage;
import com.tripmn.repository.AccountRepository;
import com.tripmn.repository.TransactionRepository;
import com.tripmn.repository.UserRepository;
import com.tripmn.service.TransactionService;
import com.tripmn.utils.PlatformUtils;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Mapper mapper;

	@Override
	@Transactional
	public TransactionResponse credit(TransactionRequest transactionRequest) {
		
		TransactionResponse response = new TransactionResponse();
		Transaction transaction = null;
		if(transactionRequest.getTransactionId() > 0){
			transaction = transactionRepository.findOne(transactionRequest.getTransactionId());
		}
		else{
			transaction = new Transaction();
		}
		if(transaction == null){
			PlatformUtils.addError(response, TransactionServiceMessage.INVALID_TRANSACTION_ID);
			return response;
		}
		
		Account account = null;
		if(transactionRequest.getAccountId() > 0){
			account = accountRepository.findById(transactionRequest.getAccountId(), true);
		}
		else{
			account = transaction.getAccount();
		}		
		if(account == null){
			PlatformUtils.addError(response, TransactionServiceMessage.INVALID_ACCOUNT_ID);
			return response;
		}
		
		if(transactionRequest.getSettleType() == 1){
			response = initiateCredit(transactionRequest, transaction, account, response);
		}
		else if(transactionRequest.getSettleType() == 2){
			response = completeCredit(transactionRequest, transaction, account, response);
		}
		else if(transactionRequest.getSettleType() == 3){
			response = initiateCredit(transactionRequest, transaction, account, response);
			if(PlatformUtils.isSuccess(response)){
				response = completeCredit(transactionRequest, transaction, account, response);
			}
		}
		
		transactionRepository.makePersistent(transaction);
		accountRepository.makePersistent(account);
		
		response.setAccountId(account.getId());
		response.setAmount(transaction.getTxnAmount());
		response.setCrDrInd(transaction.getCrDrInd());
		response.setTxnStatus(transaction.getStatus());
		response.setUserId(account.getUser().getId());
				
		return response;
	}

	@Override
	@Transactional
	public TransactionResponse debit(TransactionRequest transactionRequest) {
		
		TransactionResponse response = new TransactionResponse();
		Transaction transaction = null;
		if(transactionRequest.getTransactionId() > 0){
			transaction = transactionRepository.findOne(transactionRequest.getTransactionId());
		}
		else{
			transaction = new Transaction();
		}
		if(transaction == null){
			PlatformUtils.addError(response, TransactionServiceMessage.INVALID_TRANSACTION_ID);
			return response;
		}
		
		Account account = null;
		if(transactionRequest.getAccountId() > 0){
			account = accountRepository.findById(transactionRequest.getAccountId(), true);
		}
		else{
			account = transaction.getAccount();
		}		
		if(account == null){
			PlatformUtils.addError(response, TransactionServiceMessage.INVALID_ACCOUNT_ID);
			return response;
		}
		if(transactionRequest.getSettleType() == 1){
			response = initiateDebit(transactionRequest, transaction, account, response);
		}
		else if(transactionRequest.getSettleType() == 2){
			response = completeDebit(transactionRequest, transaction, account, response);
		}
		else if(transactionRequest.getSettleType() == 3){
			response = initiateDebit(transactionRequest, transaction, account, response);
			if(PlatformUtils.isSuccess(response)){
				response = completeDebit(transactionRequest, transaction, account, response);
			}
		}
		
		if(PlatformUtils.isSuccess(response)){
			transactionRepository.makePersistent(transaction);
			accountRepository.makePersistent(account);	
		}
		
		response.setAccountId(account.getId());
		response.setAmount(transaction.getTxnAmount());
		response.setCrDrInd(transaction.getCrDrInd());
		response.setTxnStatus(transaction.getStatus());
		response.setUserId(account.getUser().getId());
		response.setTransactionId(transaction.getId());
				
		return response;
	}
	
	@Override
	public AccountCreationResponse createAccount(
			AccountCreationRequest accountCreationRequest) {

		AccountCreationResponse response = new AccountCreationResponse();

		if (accountCreationRequest == null) {
			PlatformUtils.addError(response, PlatformMessage.INVALID_REQUEST);
			return response;
		}

		User user = userRepository.findOne(accountCreationRequest.getUserId());
		if (user == null) {
			PlatformUtils.addError(response, UserServiceMessage.INVALID_USER_ID);
			return response;
		}

		Account account = new Account();
		account.setAccountType(accountCreationRequest.getAccountType());
		account.setUser(user);
		account.setStatus(AccountStatus.Active);

		account = accountRepository.makePersistent(account);
		TransactionRequest txnRequest = new TransactionRequest();
		txnRequest.setAccountId(account.getId());
		txnRequest.setAmount(accountCreationRequest.getInitialBalance());
		txnRequest.setComments("Intial credit");
		txnRequest.setCrDrInd((short) 1);
		txnRequest.setUserId(account.getUser().getId());
		txnRequest.setTxnStatus(TxnStatus.Success);
		txnRequest.setSettleType((short)3);
		TransactionResponse txnResponse = credit(txnRequest);
		if(!PlatformUtils.isSuccess(txnResponse)){
			PlatformUtils.addError(response, txnResponse);
		}
		account = accountRepository.findById(account.getId(), true);
		response.setAccountId(account.getId());
		response.setStatus(account.getStatus());
		response.setAvailableBalance(account.getAvailableBalance());

		return response;
	}
	
	private TransactionResponse initiateCredit(
			TransactionRequest transactionRequest, Transaction transaction,
			Account account, TransactionResponse response) {
		
		transaction.setCrDrInd((short)1);
		transaction.setStatus(TxnStatus.Pending);
		transaction.setAccount(account);
		transaction.setComments(transactionRequest.getComments());
		transaction.setTxnAmount(transactionRequest.getAmount());
		transaction.setAvailableBalance(account.getAvailableBalance());
		transaction.setBlockedBalance(account.getCreditBlockedBalance());
		transaction.setAvailableBalance(account.getAvailableBalance());
		account.setCreditBlockedBalance(account.getCreditBlockedBalance() + transactionRequest.getAmount());
				
		return response;

	}

	private TransactionResponse initiateDebit(
			TransactionRequest transactionRequest, Transaction transaction,
			Account account, TransactionResponse response) {
		
		transaction.setCrDrInd((short)-1);
		if((account.getAvailableBalance() - transactionRequest.getAmount()) < 0){
			PlatformUtils.addError(response, TransactionServiceMessage.INSUFFICIENT_BALANCE);
			return response;
		}
		transaction.setStatus(TxnStatus.Pending);
		transaction.setAccount(account);
		transaction.setComments(transactionRequest.getComments());
		transaction.setTxnAmount(transactionRequest.getAmount());
		transaction.setAvailableBalance(account.getAvailableBalance());
		transaction.setBlockedBalance(account.getDebitBlockedBalance());
		transaction.setAvailableBalance(account.getAvailableBalance());
		account.setAvailableBalance(account.getAvailableBalance() - transactionRequest.getAmount());
		account.setDebitBlockedBalance(account.getDebitBlockedBalance() + transactionRequest.getAmount());
				
		return response;
	}
	
	private TransactionResponse completeCredit(
			TransactionRequest transactionRequest, Transaction transaction,
			Account account, TransactionResponse response) {
		
		transaction.setCrDrInd((short)1);
		transaction.setStatus(transactionRequest.getTxnStatus());
		transaction.setAccount(account);
		if(transactionRequest.getTxnStatus().equals(TxnStatus.Failed)){
			account.setCreditBlockedBalance(account.getCreditBlockedBalance()
					- transaction.getTxnAmount());
		}
		else{
			account.setAvailableBalance(account.getAvailableBalance() + transaction.getTxnAmount());
			account.setCreditBlockedBalance(account.getCreditBlockedBalance()
					- transaction.getTxnAmount());
		}

		return response;

	}

	private TransactionResponse completeDebit(
			TransactionRequest transactionRequest, Transaction transaction,
			Account account, TransactionResponse response) {

		transaction.setCrDrInd((short) -1);
		transaction.setStatus(TxnStatus.Success);
		transaction.setAccount(account);
		if(transactionRequest.getTxnStatus().equals(TxnStatus.Failed)){
			account.setAvailableBalance(account.getAvailableBalance() + transaction.getTxnAmount());
			account.setDebitBlockedBalance(account.getDebitBlockedBalance()
					- transaction.getTxnAmount());
		}
		else{
			account.setDebitBlockedBalance(account.getDebitBlockedBalance()
					- transaction.getTxnAmount());
		}

		return response;
	}

}
