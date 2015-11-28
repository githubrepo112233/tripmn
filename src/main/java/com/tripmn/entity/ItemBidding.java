package com.tripmn.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tripmn.enums.BiddingStatus;

@Entity
public class ItemBidding extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User winningUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	private long biddingTokens;
	
	private Date endDate;
	
	private long graceSeconds;
	
	private long retryCount;
	
	private BiddingStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getWinningUser() {
		return winningUser;
	}

	public void setWinningUser(User winningUser) {
		this.winningUser = winningUser;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getBiddingTokens() {
		return biddingTokens;
	}

	public void setBiddingTokens(long biddingTokens) {
		this.biddingTokens = biddingTokens;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getGraceSeconds() {
		return graceSeconds;
	}

	public void setGraceSeconds(long graceSeconds) {
		this.graceSeconds = graceSeconds;
	}

	public long getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(long retryCount) {
		this.retryCount = retryCount;
	}

	public BiddingStatus getStatus() {
		return status;
	}

	public void setStatus(BiddingStatus status) {
		this.status = status;
	}
}
