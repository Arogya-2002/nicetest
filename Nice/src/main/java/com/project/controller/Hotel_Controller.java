package com.project.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;
import com.project.service.Hotel_Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotels")
public class Hotel_Controller {

	
	
	@Autowired
	private Hotel_Service hotel_Service;
	
	@PostMapping("/addhotel")
    public ResponseEntity<Hotel_Model> addHotel(@RequestBody Hotel_Model hotel_Model) {
        Hotel_Model savedHotel = hotel_Service.addHotel(hotel_Model);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }
	
	@GetMapping("/{hid}")
	public void removeHotel(@RequestParam Long hid){
		hotel_Service.removeHotel(hid);
	}
	
    @GetMapping("getallhotels")
    public ResponseEntity<List<HotelDTO>> getallHotels()
    {
		return new ResponseEntity<>(hotel_Service.findAll(),HttpStatus.OK); // return all the data from the db
    }
	
	@PostMapping("/selecttype/{cid}/{type}/{days}")
	public String selectType(@PathVariable Long cid, @PathVariable String type, @PathVariable int days) {
	return hotel_Service.selectRoom(cid,type,days);
	
}
}
