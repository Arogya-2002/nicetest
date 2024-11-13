package com.project.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Hotel_Model {
	@Id
	private Long cid;
	
	private String hname;
	
	private String hAddress;
	
	private String type;
	
	private int days;
	
	
	private long cost;

	@ManyToMany
	private List<Customer_Model> customer_Model;
	
	@ManyToOne
	private Admin_Model admin_Model;
	
	
	public Hotel_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Hotel_Model(Long cid,String hname,String hAdress, String type, int days, long cost) {
		super();
		this.cid = cid;
		this.hname=hname;
		this.hAddress=hAdress;
		this.type = type;
		this.days = days;
		this.cost = cost;
	}

	public Long getCid() {
		return cid;
	}


	public void setCid(Long cid) {
		this.cid = cid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public long getCost() {
		return cost;
	}


	public void setCost(long cost) {
		this.cost = cost;
	}


	public String getHname() {
		return hname;
	}


	public void setHname(String hname) {
		this.hname = hname;
	}


	public String gethAddress() {
		return hAddress;
	}


	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

}
