package com.tripmn.repository;

import org.springframework.data.repository.Repository;
import com.tripmn.entity.Transaction;

public interface TransactionRepository extends
		BaseRepository<Transaction, Long>, Repository<Transaction, Long>,
		TransactionRepositoryCustom {

}
