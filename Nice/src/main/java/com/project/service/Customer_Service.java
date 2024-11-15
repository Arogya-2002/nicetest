package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.dto.ApiResponse;
import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;

public interface Customer_Service {
	
	public ResponseEntity<ApiResponse<Customer_dto>> cust_to_dto(Customer_Model customer);
	public ResponseEntity<ApiResponse<Customer_dto>> Register(Customer_Model customer);
	public  ResponseEntity<ApiResponse<String>> Delete(Long cid);
	public ResponseEntity<ApiResponse<Customer_Model>> Update(Long cid,Customer_Model model);
	public ResponseEntity<ApiResponse<Customer_dto>> Getcustomer(long cid);
	public ResponseEntity<ApiResponse<List<Customer_dto>>> getcustomers();

}
