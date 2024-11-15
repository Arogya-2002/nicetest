package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ApiResponse;
import com.project.service.Admin_Service;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	@Autowired
	private Admin_Service admin_Service;
	
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
