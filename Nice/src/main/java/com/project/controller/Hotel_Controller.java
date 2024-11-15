package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dto.ApiResponse;
import com.project.dto.Customer_dto;
import com.project.dto.HotelDTO;
import com.project.enums.FoodMenu;
import com.project.enums.RoomTypes;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.service.Admin_Service;
import com.project.service.Customer_Service;
import com.project.service.Hotel_Service;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/hotels")
public class Hotel_Controller {

    @Autowired
    private Hotel_Service hotel_Service;
    
    @Autowired
	private Customer_Service service;
    
    @Autowired
	private Admin_Service admin_Service;
    
    //customer part
    @Operation(summary = "REGISTER CUSTOMER", description = "you need to enter your name,unique phone number,umique adhar number")
	@PostMapping("/Registercustomer")
	public ResponseEntity<ApiResponse<Customer_dto>> RegisterUser(@RequestBody Customer_Model customer) {
		return service.Register(customer);
	}

	@Operation(summary = "DELETE CUSTOMER", description = "This operation deletes the details of the specified customer")
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<ApiResponse<String>> Deleting(@PathParam(value = "id") Long cid) 
	{
		return service.Delete(cid); 
	}

	@Operation(summary = "UPDATE CUSTOMER", description = "This operation updates the details of the specified customer")
	@PutMapping("/Updatecustomer/{cid}")
	public  ResponseEntity<ApiResponse<Customer_Model>> UpdateUser(@PathParam(value = "cid") Long cid, @RequestBody Customer_Model model) 
	{
		
		return service.Update(cid, model);
	}

	@Operation(summary = "GET ALL CUSTOMERS", description = "This operation returns the details of all the  customers")
	@GetMapping("/getallcustomers")
	public ResponseEntity<ApiResponse<List<Customer_dto>>> getallcustomers() 
	{
		return service.getcustomers();
	}

	@Operation(summary = "GET CUSTOMER BY ID", description = "This operation returns the details of the specified customer")
	@GetMapping("/getcustomerbyid/{cid}")
	public ResponseEntity<ApiResponse<Customer_dto>> Getcustomer(@PathVariable Long cid) 
	{
		return service.Getcustomer(cid);
	}
	
	
	
	
	@Operation(summary = "GET ROOM BILL",description = "You need to enter Customer ID and This operation returns the room bill of the specified customer")
	@GetMapping("/getroombill/{cid}")
	public ResponseEntity<ApiResponse<String>> getroombill(@PathParam(value="cid") Long cid) {
		return admin_Service.getRoomBill(cid);
	}
	
	@Operation(summary = "GET FOOD BILL",description = "you need to enter Customer ID and This operation returns the food bill of the specified customer")
	@GetMapping("/getfoodbill/{cid}")
	public ResponseEntity<ApiResponse<String>> getfoodbill(@PathParam(value="cid") Long cid) {
		return admin_Service.getFoodBill(cid);
	}
	
	@Operation(summary = "GET TOTAL BILL",description = "you need to enter Customer ID and This operation returns the Total bill of the specified customer")
	@GetMapping("/getTotalbill/{cid}")
	public ResponseEntity<ApiResponse<Double>> gettotalbill(@PathParam(value="cid") Long cid) {
		return admin_Service.getTotalBill(cid);
	}
	
	@Operation(summary = "BILL PAYMENT",description = "PLease enter your Customer ID and your valid caed details")
	@GetMapping("/billPayment/{cid}/{cardnumber}/{cvv}")
	public ResponseEntity<ApiResponse<String>> billPayment(@PathParam(value="cid") Long cid,@PathParam(value="cardnumber") String cardnumber,@PathParam(value="cvv") String cvv) {
		return admin_Service.AmountPaid(cid,cardnumber,cvv);
	}
	
}