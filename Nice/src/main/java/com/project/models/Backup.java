package com.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Backup {
	
	@Id
	private Long cid;
	private String cname;
	private String cnumber;
	private String cadharno;
	private Long hotelid;
	private String hotelname;
	private String hotelAddress;
	private Integer roomBill;
	private Double foodBill;
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
	public Integer getRoomBill() {
		return roomBill;
	}
	public void setRoomBill(Integer roomBill) {
		this.roomBill = roomBill;
	}
	public Double getFoodBill() {
		return foodBill;
	}
	public void setFoodBill(Double foodBill) {
		this.foodBill = foodBill;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getCadharno() {
		return cadharno;
	}
	public void setCadharno(String cadharno) {
		this.cadharno = cadharno;
	}
	public Backup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Backup(Long cid, String cname, String cnumber, String cadharno, Long hotelid, String hotelname,
			String hotelAddress, Integer roomBill, Double foodBill) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cnumber = cnumber;
		this.cadharno = cadharno;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hotelAddress = hotelAddress;
		this.roomBill = roomBill;
		this.foodBill = foodBill;
	}

	
	
	
}
