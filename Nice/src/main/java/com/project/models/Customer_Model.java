package com.project.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.UniqueConstraint;

@Entity
public class Customer_Model {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long cid;
	
	private String cname;
	
	@Column(unique = true)
	private Long cnumber;
	
	@Column(unique = true)
	private Long cadharno;
	
	@ManyToOne(cascade =CascadeType.ALL)
	private Admin_Model admin_Model;
	
	@ManyToMany(mappedBy = "customer_Model")
	private List<Hotel_Model> hotel_Model;

	public Customer_Model(Long cid, String cname, Long cnumber, Long cadharno) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cnumber = cnumber;
		this.cadharno = cadharno;
	}

	public Customer_Model() {
		super();
		// TODO Auto-generated constructor stub
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

	public Long getCnumber() {
		return cnumber;
	}

	public void setCnumber(Long cnumber) {
		this.cnumber = cnumber;
	}

	public Long getCadharno() {
		return cadharno;
	}

	public void setCadharno(Long cadharno) {
		this.cadharno = cadharno;
	}
	
	
	
	
}