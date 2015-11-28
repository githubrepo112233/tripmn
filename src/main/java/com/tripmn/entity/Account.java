package com.tripmn.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.tripmn.enums.AccountStatus;
import com.tripmn.enums.AccountType;

@Entity
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	private AccountType accountType;
	
	private AccountStatus status;
	
	private long availableBalance;

	private long debitBlockedBalance;
	
	private long creditBlockedBalance;

	private long cumulativeBalance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public long getDebitBlockedBalance() {
		return debitBlockedBalance;
	}

	public void setDebitBlockedBalance(long debitBlockedBalance) {
		this.debitBlockedBalance = debitBlockedBalance;
	}

	public long getCreditBlockedBalance() {
		return creditBlockedBalance;
	}

	public void setCreditBlockedBalance(long creditBlockedBalance) {
		this.creditBlockedBalance = creditBlockedBalance;
	}

	public long getCumulativeBalance() {
		return cumulativeBalance;
	}

	public void setCumulativeBalance(long cumulativeBalance) {
		this.cumulativeBalance = cumulativeBalance;
	}
}
