package com.project.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
 
@Entity
public class Hotel_Model {
	@Id
	private Long hotelid;
	private String hotelname;
	private String hotelAddress;
	private String hoteltype;
	private Double costperDay;
	
	private Integer roomBill;
	private Double foodBill;

 
	@ManyToMany
	private List<Customer_Model> customer_Model;
	@ManyToOne
	private Admin_Model admin_Model;

	public Hotel_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
 
 
	public Hotel_Model(Long hotelid, String hotelname, String hotelAddress, String hoteltype, Double costperDay) {
		super();
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hotelAddress = hotelAddress;
		this.hoteltype = hoteltype;
		this.costperDay = costperDay;
	}
 
 
	public Long getHotelid() {
		return hotelid;
	}
 
 
	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}
 
 
	public String getHotelname() {
		return hotelname;
	}
 
 
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
 
 
	public String getHotelAddress() {
		return hotelAddress;
	}
 
 
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
 
 
	public String getHoteltype() {
		return hoteltype;
	}
 
 
	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}
 
 
	public Double getCostperDay() {
		return costperDay;
	}
 
 
	public void setCostperDay(Double costperDay) {
		this.costperDay = costperDay;
	}


	public Double getFoodBil() {
		return foodBill;
	}


	public void setFoodBil(Double foodBil) {
		this.foodBill = foodBil;
	}


	public Integer getRoomBill() {
		return roomBill;
	}


	public void setRoomBill(Integer price) {
		this.roomBill = price;
	}
 
 
}