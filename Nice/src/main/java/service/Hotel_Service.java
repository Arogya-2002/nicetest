package service;

import java.util.List;

import models.Hotel_Model;

public interface Hotel_Service {
	
	public Hotel_Model addHotel(Hotel_Model hotel_Model);
	public void removeHotel(Long hid);
	public Hotel_Model getHotelById(Long hid);
	public List<Hotel_Model> getAll();
	

}
