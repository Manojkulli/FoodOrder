package com.ty.foodorderapp.foodorder_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodorderapp.foodorder_app.dto.FoodOrder;
import com.ty.foodorderapp.foodorder_app.repository.FoodOrderRepositery;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepositery repositery;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repositery.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return repositery.save(foodOrder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional=repositery.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public String deleteFoodOrderById(int id) {
		repositery.deleteById(id);
		return "Deleted";
	}
	
}
