package com.tripmn.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.tripmn.enums.TxnStatus;

@Entity
public class Transaction extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Account account;

	private TxnStatus status;

	private long txnAmount;

	private short crDrInd;

	private String comments;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemBidding itemBidding;

	private long availableBalance;

	private long blockedBalance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TxnStatus getStatus() {
		return status;
	}

	public void setStatus(TxnStatus status) {
		this.status = status;
	}

	public long getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(long txnAmount) {
		this.txnAmount = txnAmount;
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

	public ItemBidding getItemBidding() {
		return itemBidding;
	}

	public void setItemBidding(ItemBidding itemBidding) {
		this.itemBidding = itemBidding;
	}

	public long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public long getBlockedBalance() {
		return blockedBalance;
	}

	public void setBlockedBalance(long blockedBalance) {
		this.blockedBalance = blockedBalance;
	}

}
