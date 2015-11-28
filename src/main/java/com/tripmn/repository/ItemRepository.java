package com.tripmn.repository;

import org.springframework.data.repository.Repository;
import com.tripmn.entity.Item;

public interface ItemRepository extends BaseRepository<Item, Long>,
		Repository<Item, Long>, ItemRepositoryCustom {

}
