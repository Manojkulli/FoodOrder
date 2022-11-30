package com.ty.foodorderapp.foodorder_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodorderapp.foodorder_app.dto.Product;
import com.ty.foodorderapp.foodorder_app.repository.ProductRepositery;

@Repository
public class ProductDao {

	@Autowired
	ProductRepositery repositery;
	
	public Product saveProduct(Product product) {
		return repositery.save(product);
	}
	
	public Product updateProduct(Product product) {
		return repositery.save(product);
	}
	
	public Product getProductById(int id) {
		  Optional< Product> optional= repositery.findById(id);
		  if(optional.isPresent()) {
			  return optional.get();
		  }
		  return null;
	}
	
	public String deleteProductById(int id) {
		repositery.deleteById(id);
		return "Deleted";
		
	}
}
