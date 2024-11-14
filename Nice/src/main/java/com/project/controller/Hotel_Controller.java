package com.project.controller;

import java.util.HashMap;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;
import com.project.service.Hotel_Service;

import io.swagger.v3.oas.annotations.Operation;
 
 
@RestController
@RequestMapping("/hotels")
public class Hotel_Controller {
 
	
	@Autowired
	private Hotel_Service hotel_Service;
	
	@Operation(summary = "ADD HOTEL",description = "This operation Adds the hotel ")
	@PostMapping("/addhotel")
    public ResponseEntity<Hotel_Model> addHotel(@RequestBody Hotel_Model hotel_Model) {
        Hotel_Model savedHotel = hotel_Service.addHotel(hotel_Model);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }
    
    @Operation(summary = "REMOVE HOTEL",description = "This operation removes the hotel by given hotel ID")
	@DeleteMapping("/{hid}")
	public String removeHotel(@RequestParam Long hid)
	{
		 return hotel_Service.removeHotel(hid);
		//return new ResponseEntity<>(hotel,HttpStatus.OK);
		//return null;
	}
	
    @Operation(summary = "AVAILABLE HOTEL",description = "This operation returns the available hotels")
    @GetMapping("getallhotels")
    public ResponseEntity<List<HotelDTO>> getallHotels()
    {
		return new ResponseEntity<>(hotel_Service.findAll(),HttpStatus.OK); // return all the data from the db
    }
    
    @Operation(summary = "SELECT HOTELS",description = "This operation assigns the room to the customer based on the specifications he entered")
	@PostMapping("/selecthotel/{cid}/{hotelid}/{roomtype}/{days}")
	public String selectType(@PathVariable Long cid, @PathVariable Long hotelid,@PathVariable String roomtype, @PathVariable int days) {
	return hotel_Service.selectType(cid,hotelid,roomtype,days);
}
    @Operation(summary = "FOOD MENU",description = "This operation returns the food Menu")
	@GetMapping("/foodMenu")
	public HashMap<String, Double> foodMenu(){
		return hotel_Service.foodOrder();
	}
	
    @Operation(summary = "FOOD SELECTION",description = "This operation adds the item into the list and generates the bill")
	@PostMapping("/foodSelection/{cid}/{item}/{quantity}")
	public String foodSelection(@PathVariable Long cid,@PathVariable String item,@PathVariable Integer quantity) {
		return hotel_Service.foodSelect(cid,item,quantity);
	}
	
}
