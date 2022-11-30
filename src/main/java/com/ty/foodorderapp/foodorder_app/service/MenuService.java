package com.ty.foodorderapp.foodorder_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodorderapp.foodorder_app.dao.MenuDao;
import com.ty.foodorderapp.foodorder_app.dto.Menu;
import com.ty.foodorderapp.foodorder_app.dto.User;
import com.ty.foodorderapp.foodorder_app.exception.NoSuchIdFound;
import com.ty.foodorderapp.foodorder_app.exception.UnableToUpdateUser;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;

	public ResponseStructure<Menu> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessege("Menu saved");
		responseStructure.setData(menuDao.saveMenu(menu));
		return responseStructure;
	}

	public ResponseStructure<Menu> getMenuById(int id) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.OK.value());
		Menu menu = menuDao.getMenuById(id);
		if (menu != null) {
			responseStructure.setMessege("Found");
			responseStructure.setData(menu);
		} else {
			throw new NoSuchIdFound();
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteMenuById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Deleted");
		responseStructure.setData(menuDao.deleteMenuById(id));
		return responseStructure;
	}

	public ResponseStructure<Menu> updateMenu(Menu menu, int id) {
		Menu menu2 = menuDao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		if (menu2 != null) {
			menu.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Updated");
			responseStructure.setData(menuDao.updateMenu(menu));
		} else {
			throw new UnableToUpdateUser();
		}
		return responseStructure;

	}
}
