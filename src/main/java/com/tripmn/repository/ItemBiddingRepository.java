package com.tripmn.repository;

import org.springframework.data.repository.Repository;

import com.tripmn.entity.Item;
import com.tripmn.entity.ItemBidding;
import com.tripmn.enums.BiddingStatus;

public interface ItemBiddingRepository extends Repository<ItemBidding, Long>,
		BaseRepository<ItemBidding, Long>, ItemBiddingRepositoryCustom {
	public ItemBidding findByItemAndStatus(Item item, BiddingStatus status);

}
