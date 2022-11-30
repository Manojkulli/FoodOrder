package com.ty.foodorderapp.foodorder_app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.foodorderapp.foodorder_app.exception.NoSuchIdFound;
import com.ty.foodorderapp.foodorder_app.exception.UnableToUpdateUser;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NoSuchIdFound.class)
	public ResponseStructure<String> noSuchIdFound(NoSuchIdFound found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessege("No Id Found");
		responseStructure.setData(found.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(UnableToUpdateUser.class)
	public ResponseStructure<String> unableToUpdate(UnableToUpdateUser updateUser){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessege("No Id Found Unable To Update");
		responseStructure.setData(updateUser.getMessage());
		return responseStructure;
	}
}
