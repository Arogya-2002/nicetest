package com.project.service;


import java.util.HashMap;
import java.util.List;

import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;

public interface Hotel_Service {
	
	public Hotel_Model addHotel(Hotel_Model hotel_Model);
	public String removeHotel(Long hid);
	public Hotel_Model getHotelById(Long hid);
	public List<HotelDTO> findAll();
	public String selectType(Long cid, Long hotelid,String roomtype, int days);
	public HashMap<String, Double> foodOrder();
	public String foodSelect(Long cid,String item,Integer quantity);

}
