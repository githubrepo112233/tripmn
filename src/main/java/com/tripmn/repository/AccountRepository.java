package com.tripmn.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.tripmn.entity.Account;
import com.tripmn.entity.User;
import com.tripmn.enums.AccountType;

public interface AccountRepository extends Repository<Account, Long>,
		BaseRepository<Account, Long>, AccountRepositoryCustom {
	
	public List<Account> findByUser(User user);
	public Account findByUserAndAccountType(User user, AccountType accountType);

}
