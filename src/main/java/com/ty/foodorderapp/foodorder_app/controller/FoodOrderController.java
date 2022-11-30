package com.ty.foodorderapp.foodorder_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodorderapp.foodorder_app.dto.FoodOrder;
import com.ty.foodorderapp.foodorder_app.service.FoodOrderService;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@RestController
@RequestMapping("foodorder")
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping
	public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder foodOrder){
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@PutMapping
	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id){
		return foodOrderService.updateFoodOrder(foodOrder, id);
	}
	
	@GetMapping
	public ResponseStructure<FoodOrder> getFoodOrder(@RequestParam int id){
		return foodOrderService.getFoodOrderById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteFoodOrder(@RequestParam int id){
		return foodOrderService.deleteFoodOrderById(id);
	}
	
}
