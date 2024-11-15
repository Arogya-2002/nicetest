package com.project.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ApiResponse;
import com.project.dto.Customer_dto;
import com.project.enums.FoodMenu;
import com.project.enums.RoomTypes;
import com.project.models.Customer_Model;
import com.project.service.Customer_Service;
import com.project.service.Hotel_Service;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Customer")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service service;
	
	@Autowired
	private Hotel_Service hotel_Service;	

	
    @Operation(summary = "SELECT HOTEL", description = "This operation assigns the room to the customer based on specifications entered")
    @PostMapping("/selecthotel/{cid}/{hotelid}/{roomtype}/{days}")
    public ResponseEntity<ApiResponse<Double>> selectType(
            @PathVariable Long cid,
            @PathVariable Long hotelid,
            @RequestParam List<RoomTypes> roomtype,
            @PathVariable int days) {
        return hotel_Service.selectType(cid, hotelid, roomtype, days);
    }

//    @Operation(summary = "FOOD MENU", description = "This operation returns the food menu")
//    @GetMapping("/foodMenu")
//    public ResponseEntity<ApiResponse<HashMap<String, Double>>> foodMenu() 
//    {
//        return hotel_Service.foodOrder();
//    }

    @Operation(summary = "FOOD SELECTION", description = "This operation adds the item into the list and generates the bill")
    @PostMapping("/foodSelection/{cid}/{item}/{quantity}")
    public ResponseEntity<ApiResponse<Double>> foodSelection(
            @PathVariable Long cid,
            @RequestParam List<FoodMenu> foodmen,
            @PathVariable Integer quantity) {
        return hotel_Service.foodSelect(cid, foodmen, quantity);
    }
}
