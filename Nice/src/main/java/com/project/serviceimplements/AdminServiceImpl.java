package com.project.serviceimplements;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.models.Admin_Model;
import com.project.models.Hotel_Model;
import com.project.repository.Admin_Repository;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Admin_Service;
@Service
public class AdminServiceImpl implements Admin_Service{

	@SuppressWarnings("unused")
	@Autowired
	private Admin_Repository admin_Repository;
	
	@Autowired
	private Hotel_Repository hotel_Repository;
	
	@Autowired
	private CustomerRepository customerRespository;
	
	@Override
	public  Double getRoomBill(Long cid) {
		if(hotel_Repository.existsById(cid)) {
			 Hotel_Model byId = hotel_Repository.getById(cid);
			return byId.getRoomBill()+0.0;
		}
		else {
			return 0.0;
		}
	}
}


