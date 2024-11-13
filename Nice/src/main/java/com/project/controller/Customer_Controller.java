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

import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;
import com.project.service.Customer_Service;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Customer")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service service;
	
	@PostMapping("/Register")
	public ResponseEntity<Customer_dto> RegisterUser(@RequestBody Customer_Model customer) {
		return service.Register(customer);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> Deleting(@PathParam(value = "id") Long cid) {
		return service.Delete(cid);
	}
	
	
	@PutMapping("/Update/{cid}")
	public String UpdateUser(@PathParam(value = "cid") Long cid,@RequestBody Customer_Model model) {
		service.Update(cid,model);
		return "Updated succesfully";
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer_Model>> getallcustomers(){
		return service.getcustomers();
	}
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<Customer_Model> Getcustomer(@PathVariable  Long cid){
		return service.Getcustomer(cid);
	}
	
	
}
