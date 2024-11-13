package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Food;
import com.project.service.Food_Service;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private Food_Service food_service;
	
	
	@PostMapping()
	public Food addItem(@RequestBody Food food){
		return food_service.addfood(food);
	}
	
	@DeleteMapping("/{fid}")
	public void deleteItem(@PathVariable Long fid) {
		food_service.deletefood(fid);
	}
	
	@PutMapping("/{fid}")
	public Food updateItem(@PathVariable Long fid,@RequestBody Food food) {
		return food_service.updateFood(fid,food);
	}
}