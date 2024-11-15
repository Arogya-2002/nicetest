package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ApiResponse;
import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;
import com.project.service.Admin_Service;
import com.project.service.Hotel_Service;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	
	
	@Autowired
    private Hotel_Service hotel_Service;
	
	
	
	//hotel   
    @Operation(summary = "ADD HOTEL", description = "This operation Adds the hotel ")
    @PostMapping("/addhotel")
    public ResponseEntity<ApiResponse<HotelDTO>> addHotel(@RequestBody HotelDTO hoteldto) 
    {
        return hotel_Service.addHotel(hoteldto);
    }

    
    @Operation(summary = "REMOVE HOTEL", description = "This operation removes the hotel by given hotel ID")
    @DeleteMapping("/deletehotel/{hid}")
    public ResponseEntity<ApiResponse<String>> removeHotel(@PathVariable Long hid) 
    {
        return hotel_Service.removeHotel(hid);
    }

    @Operation(summary = "AVAILABLE HOTELS", description = "This operation returns the available hotels")
    @GetMapping("/getallhotels")
    public ResponseEntity<ApiResponse<List<HotelDTO>>> getAllHotels()
    {
        return hotel_Service.findAll();
    }
	
	
	
	
	
	
	


}
