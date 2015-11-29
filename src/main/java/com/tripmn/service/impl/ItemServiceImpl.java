package com.tripmn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmn.dto.FetchItemsResponse;
import com.tripmn.dto.ItemDTO;
import com.tripmn.entity.Item;
import com.tripmn.enums.TokenServceMessage;
import com.tripmn.repository.ItemRepository;
import com.tripmn.service.ItemService;
import com.tripmn.utils.PlatformUtils;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	@Transactional
	public FetchItemsResponse fetchItems() {
		FetchItemsResponse response = new FetchItemsResponse();
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<Item> itemEntityList = (List<Item>) itemRepository.findAll();
		for (Item item : itemEntityList) {
			ItemDTO itemDTO = mapper.map(item, ItemDTO.class);
			itemDTO.setEndDate(PlatformUtils.formatDate(item.getEndDate(), "yyyy-MM-dd HH:mm:ss"));
			itemList.add(itemDTO);
		}
		
		if(itemList.size() <= 0){
			PlatformUtils.addError(response, TokenServceMessage.ITEMS_NOT_AVAILABLE);
			return response;
		}
		
		response.setItemList(itemList);
				
		return response;
	}
}
