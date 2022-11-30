package com.ty.foodorderapp.foodorder_app.exception;

public class UnableToUpdateUser extends RuntimeException{

	private String messege="user id not fount unable to update";
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return messege;
	}
	public UnableToUpdateUser(String messege) {
		super();
		this.messege = messege;
	}
	public UnableToUpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
