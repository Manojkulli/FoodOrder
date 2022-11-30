package com.ty.foodorderapp.foodorder_app.exception;

public class NoSuchIdFound extends RuntimeException{

	private String messege="No such id found in database";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return messege;
	}

	public NoSuchIdFound(String messege) {
		super();
		this.messege = messege;
	}

	public NoSuchIdFound() {
		super();
	}

	
	
	

	
}
