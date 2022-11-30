package com.ty.foodorderapp.foodorder_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodorderapp.foodorder_app.dao.UserDao;
import com.ty.foodorderapp.foodorder_app.dto.User;
import com.ty.foodorderapp.foodorder_app.exception.NoSuchIdFound;
import com.ty.foodorderapp.foodorder_app.exception.UnableToUpdateUser;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessege("saved");
		responseStructure.setData(userDao.saveUser(user));
		return responseStructure;
	}

	public ResponseStructure<User> updateUser(User user, int id) {

		User user2 = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user2 != null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Found");
			responseStructure.setData(userDao.saveUser(user));
		} else {
			throw new UnableToUpdateUser();
		}
		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.OK.value());
		User user = userDao.getUserById(id);
		if (user != null) {
			responseStructure.setMessege("Found");
			responseStructure.setData(user);
		} else {
			throw new NoSuchIdFound();
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteUserById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("deleted");
		responseStructure.setData(userDao.deleteById(id));
		return responseStructure;

	}

}
