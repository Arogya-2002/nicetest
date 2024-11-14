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

	HashMap<String, Double> obj = new HashMap<String, Double>();
	HashMap<String, Double> fc = new HashMap<String, Double>();
	ArrayList<String> food_list = new ArrayList<String>();
	Hotel_Model hm = new Hotel_Model();
	Double foodprice=0.0;

	public HotelServiceImpl() {

		obj.put("suite", 2000.0);
		obj.put("delux", 1500.0);
		obj.put("non delux", 1000.0);
		obj.put("villa", 5000.0);

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
	    // Validate input
	    if (days <= 0) {
	        throw new IllegalArgumentException("Days must be greater than zero");
	    }

	    // Fetch customer and hotel data
	    Optional<Customer_Model> customer = cr.findById(cid);
	    Optional<Hotel_Model> hotel = hotel_Repository.findById(hotelid);

	    // Check if room type exists
	    if (!obj.containsKey(roomtype)) {
	        throw new Mycustomexception("Room type not available");
	    }

	    // Check if both customer and hotel exist
	    if (customer.isPresent() && hotel.isPresent()) {
	        Hotel_Model hm = hotel.get();

	        // Calculate total price
	       // Double perDayCost = obj.get(roomtype);
	        Double roomTypePrice = obj.get(roomtype);
	        if (roomTypePrice == null) {
	            throw new Mycustomexception("Invalid room type price");
	        }

	        Double totalCost = roomTypePrice * days;

	        // Update room bill and save
	        hm.setRoomBill(totalCost.intValue());
	        hotel_Repository.save(hm);

	        return "Room type selected successfully. Total cost: " + totalCost;
	    } else {
	        throw new Mycustomexception("Customer or Hotel not found");
	    }
	}


	public HashMap<String, Double> foodOrder() {
		return fc;

	}

	public String foodSelect(Long cid, String item, Integer quantity) {

	    // Check if customer ID exists
	    Optional<Hotel_Model> optionalHm = hotel_Repository.findById(cid);

	    if (optionalHm.isPresent()) {

	        // Check if the food item is available
	        if (fc.containsKey(item)) {

	            // Retrieve the hotel model and update food bill
	            Hotel_Model hm = optionalHm.get();
	            food_list.add(item);
	            Double itemCost = fc.get(item) * quantity;

	            // Update the food bill for the customer
	            Double currentFoodBill = hm.getFoodBil() != null ? hm.getFoodBil() : 0.0;
	            currentFoodBill += itemCost;
	            hm.setFoodBil(currentFoodBill);

	            // Save the updated model to the repository
	            hotel_Repository.save(hm);
	            return "Item added successfully";
	        } else {
	            throw new Mycustomexception("Item not found");
	        }

	    } else {
	        throw new Mycustomexception("Invalid cid");
	    }
	}

}