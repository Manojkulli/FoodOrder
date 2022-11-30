package com.ty.foodorderapp.foodorder_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodorderapp.foodorder_app.dto.Items;

public interface ItemsRepositery extends JpaRepository<Items, Integer>{

}
