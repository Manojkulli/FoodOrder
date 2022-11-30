package com.ty.foodorderapp.foodorder_app.dao;

import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodorderapp.foodorder_app.dto.Items;
import com.ty.foodorderapp.foodorder_app.repository.ItemsRepositery;

@Repository
public class ItemsDao {

	@Autowired
	ItemsRepositery repositery;
	
	public Items saveItem(Items items) {
		return repositery.save(items);
	}
	
	public Items updateItem(Items items) {
		return repositery.save(items);
	}
	
	public Items getItemById(int id) {
		Optional<Items> optional= repositery.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public String deleteItemById(int id) {
		repositery.deleteById(id);
		return "Deleted";
	}
}
