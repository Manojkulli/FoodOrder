package com.ty.foodorderapp.foodorder_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodorderapp.foodorder_app.dto.Product;

public interface ProductRepositery extends JpaRepository<Product, Integer>{

}
