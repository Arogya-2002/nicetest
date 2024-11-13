package com.project.serviceimplements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;
import com.project.repository.Hotel_Repository;
import com.project.service.Hotel_Service;

@Service
public class HotelServiceImpl implements Hotel_Service{
	
	
	@Autowired
	private Hotel_Repository hotel_Repository;
	
	
	
	HashMap<String,Integer> obj=new HashMap();
	
	 public HotelServiceImpl() {
	        obj.put("suite", 2000);  
	        obj.put("deluxe", 1500);  
	    }

	 @Override
	public Hotel_Model addHotel(Hotel_Model hotel_Model) {
		return hotel_Repository.save(hotel_Model);
	}
	
	 @Override
	public void removeHotel(Long hid) {
		hotel_Repository.deleteById(hid);
	}
	
	 @Override
	public Hotel_Model getHotelById(Long hid) {
		return hotel_Repository.findById(hid)
				.orElseThrow(() -> new RuntimeException("Hotel not found"));
	}
	 @Override
	public List<HotelDTO> findAll() {
		   List<Hotel_Model> hotels = hotel_Repository.findAll();
		   List<HotelDTO> allhotels = new ArrayList<HotelDTO>();
		   
		   for(Hotel_Model hotel_Model : hotels)
		   {
			   HotelDTO dto = new HotelDTO(hotel_Model.getCid(),hotel_Model.getHname(),hotel_Model.gethAddress());
			   allhotels.add(dto);
		   }
		   return allhotels;
		
	}
	@Override
	 public String selectRoom(Long cid,String type,int days) {
		 if (obj.containsKey(type)) {
	            int price = obj.get(type);
	            price=price*days;
	            Hotel_Model obj1=new Hotel_Model();
	            obj1.setCid( cid);
	            obj1.setType(type);
	            obj1.setDays(days);
	            obj1.setCost(price);
	            
	            hotel_Repository.save(obj1);
	            return "Room is given. Room type: " + type + ", Price: " + price;
	        } else {
	            return "Room type not available";
	        }
		
	}

	
	
}
