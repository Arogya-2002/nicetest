package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Admin_Model;
import com.project.service.Admin_Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	@Autowired
	private Admin_Service admin_Service;
	
	@Operation(summary = "GET ROOM BILL",description = "You need to enter Customer ID and This operation returns the room bill of the specified customer")
	@GetMapping("/getroombill/{cid}")
	public String getroombill(@PathParam(value="cid") Long cid) {
		return admin_Service.getRoomBill(cid);
	}
	
	@Operation(summary = "GET FOOD BILL",description = "you need to enter Customer ID and This operation returns the food bill of the specified customer")
	@GetMapping("/getfoodbill/{cid}")
	public String getfoodbill(@PathParam(value="cid") Long cid) {
		return admin_Service.getFoodBill(cid);
	}
	
	@Operation(summary = "GET TOTAL BILL",description = "you need to enter Customer ID and This operation returns the Total bill of the specified customer")
	@GetMapping("/getTotalbill/{cid}")
	public Double gettotalbill(@PathParam(value="cid") Long cid) {
		return admin_Service.getTotalBill(cid);
	}
	
	
	

}
