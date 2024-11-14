package com.project.service;


public interface Admin_Service {

	public  String getRoomBill(Long cid);
	public String getFoodBill(Long cid);
	public Double getTotalBill(Long cid);
}
