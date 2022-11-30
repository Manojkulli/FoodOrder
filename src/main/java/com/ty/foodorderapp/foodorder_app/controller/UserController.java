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

import com.ty.foodorderapp.foodorder_app.dto.User;
import com.ty.foodorderapp.foodorder_app.service.UserService;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PutMapping
	public ResponseStructure<User> updateUser(@RequestBody User user,@RequestParam int id) {
		return service.updateUser(user,  id);
	}
	
	@GetMapping
	public ResponseStructure<User> getUserById(@RequestParam int id) {
		return service.getUserById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id) {
		return service.deleteUserById(id);
	}
	

}
