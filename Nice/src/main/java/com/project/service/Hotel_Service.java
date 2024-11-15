package com.project.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.dto.ApiResponse;
import com.project.dto.HotelDTO;
import com.project.enums.FoodMenu;
import com.project.enums.RoomTypes;
import com.project.models.Hotel_Model;

public interface Hotel_Service {
	
	public ResponseEntity<ApiResponse<HotelDTO>> addHotel(HotelDTO hoteldto);
	public ResponseEntity<ApiResponse<String>> removeHotel(Long hid);
	public ResponseEntity<ApiResponse<Hotel_Model>> getHotelById(Long hid);
	public ResponseEntity<ApiResponse<List<HotelDTO>>> findAll();
	public ResponseEntity<ApiResponse<Double>> foodSelect(Long cid,List<FoodMenu> foodmen,Integer quantity);
    public ResponseEntity<ApiResponse<Double>> selectType(Long cid, Long hotelid, List<RoomTypes> roomtype, int days);
}