package com.project.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.models.Admin_Model;
import com.project.repository.Admin_Repository;
import com.project.repository.FoodRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Admin_Service;
@Service
public class AdminServiceImpl implements Admin_Service{

	@SuppressWarnings("unused")
	@Autowired
	private Admin_Repository admin_Repository;
	
	@Autowired
	private FoodRepository food_Repository;
	
	@Autowired
	private Hotel_Repository hotel_Repository;
	
	
	@Override
	public Admin_Model getAll(Long cid) {
		
		
		
		return null;
	}
}


