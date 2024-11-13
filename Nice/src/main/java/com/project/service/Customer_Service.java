package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;

public interface Customer_Service {
	
	public ResponseEntity<Customer_dto> cust_to_dto(Customer_Model customer);
	public ResponseEntity<Customer_dto> Register(Customer_Model customer);
	public  ResponseEntity<String> Delete(Long cid);
	public ResponseEntity<Customer_Model> Update(Long cid,Customer_Model model);
	public ResponseEntity<Customer_Model> Getcustomer(long cid);
	public ResponseEntity<List<Customer_Model>> getcustomers();

}
