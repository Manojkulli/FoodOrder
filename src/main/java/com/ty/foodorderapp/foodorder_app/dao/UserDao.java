package com.ty.foodorderapp.foodorder_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodorderapp.foodorder_app.dto.User;
import com.ty.foodorderapp.foodorder_app.repository.UserRepositery;

@Repository
public class UserDao {
	
	@Autowired
	UserRepositery repositery;
	
	public User saveUser(User user) {
		return repositery.save(user);	
	}
	
	public User updateUser(User user) {
		return repositery.save(user);	
	}
	

	public User getUserById(int id) {
		Optional<User> optional=  repositery.findById(id);	
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public String deleteById(int id) {
		repositery.deleteById(id);
		return "Deleted";
		
		
	}

}
