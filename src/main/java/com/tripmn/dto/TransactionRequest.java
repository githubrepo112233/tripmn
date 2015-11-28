package com.tripmn.dto;

import com.tripmn.enums.TxnStatus;

public class TransactionRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	private long userId;
	private long accountId;
	private long amount;
	private short crDrInd;
	private String comments;
	private TxnStatus txnStatus;
	private long transactionId;
	private short settleType;

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

	public short getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(short crDrInd) {
		this.crDrInd = crDrInd;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public TxnStatus getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(TxnStatus txnStatus) {
		this.txnStatus = txnStatus;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public short getSettleType() {
		return settleType;
	}

	public void setSettleType(short settleType) {
		this.settleType = settleType;
	}
}
