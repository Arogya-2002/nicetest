package com.project.serviceimplements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.HotelDTO;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Hotel_Service;

@Service
public class HotelServiceImpl implements Hotel_Service {

	HashMap<String, Integer> obj = new HashMap<String, Integer>();
	HashMap<String, Double> fc = new HashMap<String, Double>();
	ArrayList<String> food_list = new ArrayList<String>();
	Hotel_Model hm = new Hotel_Model();

	public HotelServiceImpl() {

		obj.put("suite", 2000);
		obj.put("delux", 1500);
		obj.put("non delux", 1000);
		obj.put("villa", 5000);

		fc.put("chicken curry", 250.0);
		fc.put("butter chicken ", 450.0);
		fc.put("mutton curry", 550.0);
		fc.put("fish curry", 250.0);
		fc.put("prawns curry", 750.0);
		fc.put("paneer curry", 150.0);
		fc.put("mushroom curry", 150.0);
		fc.put("chilli chicken ", 250.0);
		fc.put("chicken lolipop", 250.0);
		fc.put("chicken biryani", 350.0);
		fc.put("chicken mandi", 750.0);
		fc.put("mutton mandi", 950.0);
		fc.put("mutton biryani", 550.0);
		fc.put("gulabjam", 50.0);

	}

	@Autowired
	private Hotel_Repository hotel_Repository;
	@Autowired
	private CustomerRepository cr;

	@Override
	public Hotel_Model addHotel(Hotel_Model hotel_Model) {
		return hotel_Repository.save(hotel_Model);
	}

	@Override
	public String removeHotel(Long hotelid) {
		hotel_Repository.deleteById(hotelid);
		return "deleted hotel with" + hotelid + "Successfully";
	}

	@Override
	public Hotel_Model getHotelById(Long hotelid) {
		return hotel_Repository.findById(hotelid).orElseThrow(() -> new RuntimeException("Hotel not found"));
	}

	@Override
	public List<HotelDTO> findAll() {
		List<Hotel_Model> hotels = hotel_Repository.findAll();
		List<HotelDTO> allhotels = new ArrayList<HotelDTO>();
		for (Hotel_Model hotel_Model : hotels) {
			HotelDTO dto = new HotelDTO(hotel_Model.getHotelid(), hotel_Model.getHotelname(),
					hotel_Model.getHotelAddress());
			allhotels.add(dto);
		}
		return allhotels;
	}

	@Override
	public String selectType(Long cid, Long hotelid, String roomtype, int days) {
		Integer price = 0;
		Optional<Customer_Model> customer = cr.findById(cid);
		Optional<Hotel_Model> hotel = hotel_Repository.findById(hotelid);
		if (obj.containsKey(roomtype)) {
			price = obj.get(roomtype);
		}

		if (customer.isPresent() && hotel.isPresent()) {
			Double perdaycost = hotel.get().getCostperDay();
			price = (int) (price * days * perdaycost);

			hm.setRoomBill(price);
			hotel_Repository.save(hm);
			return "success";
		} else {
			return "Room type not available";
		}
	}

	public HashMap<String, Double> foodOrder() {
		return fc;

	}

	public String foodSelect(Long cid, String item, Integer quantity) {

		if (cr.existsById(cid)) {

			if (fc.containsKey(item)) {

				food_list.add(item);
				return "item added";
			} else {
				throw new Mycustomexception("Item not found");
			}

		} else {
			throw new Mycustomexception("Inavlid cid");
		}
	
		
	}

//	Double foodprice=0.0;
//	for(String str:food_list)
//	{
//		foodprice += fc.get(str);
//	}
//	Hotel_Model byId = hotel_Repository.getById(cid);hm.setFoodBil(foodprice);hotel_Repository.save(hm);

}