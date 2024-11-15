package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dto.ApiResponse;
import com.project.dto.HotelDTO;
import com.project.enums.FoodMenu;
import com.project.enums.RoomTypes;
import com.project.models.Hotel_Model;
import com.project.service.Hotel_Service;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/hotels")
public class Hotel_Controller {

    @Autowired
    private Hotel_Service hotel_Service;

    @Operation(summary = "ADD HOTEL", description = "This operation Adds the hotel ")
    @PostMapping("/addhotel")
    public ResponseEntity<ApiResponse<Hotel_Model>> addHotel(@RequestBody HotelDTO hoteldto) 
    {
        return hotel_Service.addHotel(hoteldto);
    }

    
    @Operation(summary = "REMOVE HOTEL", description = "This operation removes the hotel by given hotel ID")
    @DeleteMapping("/{hid}")
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
    public ResponseEntity<ApiResponse<String>> foodSelection(
            @PathVariable Long cid,
            @RequestParam List<FoodMenu> foodmen,
            @PathVariable Integer quantity) {
        return hotel_Service.foodSelect(cid, foodmen, quantity);
    }
}