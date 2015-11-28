package com.tripmn.repository;

import org.springframework.data.repository.Repository;
import com.tripmn.entity.Token;

public interface TokenRepository extends Repository<Token, Long>,
		BaseRepository<Token, Long>, TokenRepositoryCustom {

}
