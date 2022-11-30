package com.ty.foodorderapp.foodorder_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodorderapp.foodorder_app.dto.Menu;

public interface MenuRepositery extends JpaRepository<Menu, Integer>{

}
