package com.tripmn.dto;

import com.tripmn.enums.TxnStatus;

public class TransactionResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private long userId;
	private long accountId;
	private long amount;
	private TxnStatus txnStatus;
	private short crDrInd;
	private long transactionId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public TxnStatus getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(TxnStatus txnStatus) {
		this.txnStatus = txnStatus;
	}

	public short getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(short crDrInd) {
		this.crDrInd = crDrInd;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
}
