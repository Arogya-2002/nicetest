package com.project.models;

import java.util.List;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin_Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;

	@Column(name = "admin_name")
	private String aname;
	
	@OneToMany
	private List<Customer_Model> customer_Model;
	
	@OneToMany
	private List<Hotel_Model> hotel_Model;

	public Admin_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin_Model(Long adminId, String aname) {
		super();
		this.adminId = adminId;
		this.aname = aname;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

}
