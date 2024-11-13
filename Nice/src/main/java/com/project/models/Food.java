package com.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fid;
	private String fname;
	private Double fcost;
	
	public Food() {
		
	}
	public Food(Long fid, String fname, Double fcost) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fcost = fcost;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getFcost() {
		return fcost;
	}
	public void setFcost(Double fcost) {
		this.fcost = fcost;
	}
	
	

}
