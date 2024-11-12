package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Hotel_Model;
import service.Hotel_Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotels")
public class Hotel_Controller {

	
	
	@Autowired
	private Hotel_Service hotel_Service;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel_Model> addHotel(@RequestBody Hotel_Model hotel_Model){
		return new ResponseEntity<>(hotel_Service.addHotel(hotel_Model),HttpStatus.CREATED);
	}
	
	@GetMapping("/{hid}")
	public void removeHotel(@RequestParam Long hid){
		hotel_Service.removeHotel(hid);
	}
	
	@GetMapping
	public List<Hotel_Model> getAll(){
		return hotel_Service.getAll();
	}
	
}
