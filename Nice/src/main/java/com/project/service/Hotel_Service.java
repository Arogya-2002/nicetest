package com.project.service;

import java.util.List;

import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;

public interface Hotel_Service {
	
	public Hotel_Model addHotel(Hotel_Model hotel_Model);
	public void removeHotel(Long hid);
	public Hotel_Model getHotelById(Long hid);
	public List<HotelDTO> findAll();
	public String selectRoom(Long cid,String type,int days);
	

}
