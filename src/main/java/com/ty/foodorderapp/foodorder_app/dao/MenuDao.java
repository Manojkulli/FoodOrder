package com.ty.foodorderapp.foodorder_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodorderapp.foodorder_app.dto.Menu;
import com.ty.foodorderapp.foodorder_app.repository.MenuRepositery;

@Repository
public class MenuDao {

	@Autowired
	MenuRepositery repositery;
	
	public Menu saveMenu(Menu menu) {
		return repositery.save(menu);
	}
	
	public Menu updateMenu(Menu menu) {
		return repositery.save(menu);
	}
	
	public Menu getMenuById(int id) {
		Optional<Menu> optional=repositery.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteMenuById(int id) {
		repositery.deleteById(id);
		return "Deleted";
	}
}
