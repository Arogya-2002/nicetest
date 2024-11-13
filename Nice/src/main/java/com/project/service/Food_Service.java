package com.project.service;

import com.project.models.Food;

public interface Food_Service {

	public Food addfood(Food food);
	public void deletefood(Long fid);
	public Food updateFood(Long fid,Food food);
}
	

