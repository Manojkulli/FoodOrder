package com.ty.foodorderapp.foodorder_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodorderapp.foodorder_app.dao.ItemsDao;
import com.ty.foodorderapp.foodorder_app.dto.Items;
import com.ty.foodorderapp.foodorder_app.exception.NoSuchIdFound;
import com.ty.foodorderapp.foodorder_app.exception.UnableToUpdateUser;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	ItemsDao itemsDao;
	
	public ResponseStructure<Items> saveItems(Items items) {
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessege("saved");
		responseStructure.setData(itemsDao.saveItem(items));
		return responseStructure;
	}
	
	public ResponseStructure<Items> updateItems(Items items,int id) {
		Items items2=itemsDao.getItemById(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		if(items!=null) {
			items.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("updated");
		responseStructure.setData(itemsDao.updateItem(items));
		}else {
			throw new UnableToUpdateUser();
		}
		return responseStructure;
	}
	
	public ResponseStructure<Items> getItemsById(int id) {
		Items items2=itemsDao.getItemById(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		if(items2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Found");
		responseStructure.setData(items2);
		}else {
			throw new NoSuchIdFound();
		}
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteItemsById(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("deleted");
		responseStructure.setData(itemsDao.deleteItemById(id));
		return responseStructure;
	}
	
	
	
}
