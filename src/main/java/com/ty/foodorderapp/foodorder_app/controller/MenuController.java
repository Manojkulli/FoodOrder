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

import com.ty.foodorderapp.foodorder_app.dto.Menu;
import com.ty.foodorderapp.foodorder_app.service.MenuService;
import com.ty.foodorderapp.foodorder_app.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@PostMapping
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu){
		return menuService.saveMenu(menu);
	}

	@GetMapping
	public ResponseStructure<Menu> getMenuById(@RequestParam int id){
		return menuService.getMenuById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> saveMenu(@RequestParam int id){
		return menuService.deleteMenuById(id);
	}
	
	@PutMapping
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu,@RequestParam int id){
		return menuService.updateMenu(menu, id);
	}
}
