package serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Hotel_Model;
import repository.Hotel_Repository;
import service.Hotel_Service;

@Service
public class HotelServiceImpl implements Hotel_Service{
	@Autowired
	private Hotel_Repository hotel_Repository;

	public Hotel_Model addHotel(Hotel_Model hotel_Model) {
		return hotel_Repository.save(hotel_Model);
	}
	
	public void removeHotel(Long hid) {
		hotel_Repository.deleteById(hid);
	}
	
	public Hotel_Model getHotelById(Long hid) {
		return hotel_Repository.findById(hid)
				.orElseThrow(() -> new RuntimeException("Hotel not found"));
	}

	public List<Hotel_Model> getAll() {
		return hotel_Repository.findAll();
		
	}

}
