package com.project.service;

import org.springframework.http.ResponseEntity;

import com.project.dto.ApiResponse;

public interface Admin_Service {

	public  ResponseEntity<ApiResponse<String>> getRoomBill(Long cid);
	public ResponseEntity<ApiResponse<String>> getFoodBill(Long cid);
	public ResponseEntity<ApiResponse<Double>> getTotalBill(Long cid);
	public ResponseEntity<ApiResponse<String>> AmountPaid(Long cid,String cardnumber,String cvv);
}