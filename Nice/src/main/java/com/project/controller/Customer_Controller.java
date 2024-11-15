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
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ApiResponse;
import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;
import com.project.service.Customer_Service;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Customer")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service service;

	@Operation(summary = "REGISTER CUSTOMER", description = "you need to enter your name,unique phone number,umique adhar number")
	@PostMapping("/Register")
	public ResponseEntity<ApiResponse<Customer_dto>> RegisterUser(@RequestBody Customer_Model customer) {
		return service.Register(customer);
	}

	@Operation(summary = "DELETE CUSTOMER", description = "This operation deletes the details of the specified customer")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<String>> Deleting(@PathParam(value = "id") Long cid) 
	{
		return service.Delete(cid);
	}

	@Operation(summary = "UPDATE CUSTOMER", description = "This operation updates the details of the specified customer")
	@PutMapping("/Update/{cid}")
	public  ResponseEntity<ApiResponse<Customer_Model>> UpdateUser(@PathParam(value = "cid") Long cid, @RequestBody Customer_Model model) 
	{
		
		return service.Update(cid, model);
	}

	@Operation(summary = "GET ALL CUSTOMERS", description = "This operation returns the details of all the  customers")
	@GetMapping("/getall")
	public ResponseEntity<ApiResponse<List<Customer_dto>>> getallcustomers() 
	{
		return service.getcustomers();
	}

	@Operation(summary = "GET CUSTOMER BY ID", description = "This operation returns the details of the specified customer")
	@GetMapping("/get/{cid}")
	public ResponseEntity<ApiResponse<Customer_dto>> Getcustomer(@PathVariable Long cid) 
	{
		return service.Getcustomer(cid);
	}
}
