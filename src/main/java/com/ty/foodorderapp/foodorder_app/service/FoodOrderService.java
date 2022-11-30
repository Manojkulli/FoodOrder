package com.ty.foodorderapp.foodorder_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodorderapp.foodorder_app.dao.FoodOrderDao;
import com.ty.foodorderapp.foodorder_app.dto.FoodOrder;
import com.ty.foodorderapp.foodorder_app.dto.Product;
import com.ty.foodorderapp.foodorder_app.exception.NoSuchIdFound;
import com.ty.foodorderapp.foodorder_app.exception.UnableToUpdateUser;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;
	
	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		List<Product> list=foodOrder.getProducts();
		double totalcost=0;
		for (Product product : list) {
			totalcost+=product.getPrice()*product.getQuantity();
		}
		totalcost+=totalcost*0.18;
		foodOrder.setTotalcost(totalcost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessege("saved");
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return responseStructure;	
	}
	
	public  ResponseStructure<FoodOrder> getFoodOrderById(int id){
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
		if(foodOrder!=null) {
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessege("Found");
        responseStructure.setData( foodOrder);
        }else {
        	throw new NoSuchIdFound();
        }
		return responseStructure;
	}
	
	public  ResponseStructure<String> deleteFoodOrderById(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Deleted");
		responseStructure.setData(foodOrderDao.deleteFoodOrderById(id));
		return responseStructure;

	}
	
	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodOrder,int id){
		FoodOrder foodOrder2=foodOrderDao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
        if(foodOrder2!=null) {
        	foodOrder.setId(id);
        	responseStructure.setStatus(HttpStatus.OK.value());
        	responseStructure.setMessege("Updated");
        	responseStructure.setData(foodOrderDao.updateFoodOrder(foodOrder));
        }else {
        	throw new UnableToUpdateUser();
        }
        return responseStructure;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
