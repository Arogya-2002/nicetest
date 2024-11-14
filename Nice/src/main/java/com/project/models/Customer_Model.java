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
import jakarta.validation.constraints.Size;
//import jakarta.persistence.UniqueConstraint;

@Entity
public class Customer_Model {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long cid;
	
	private String cname;
	
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	@Column(unique = true)
	private String cnumber;
	
	 @Size(min = 12, max = 12, message = "Adhar number must be exactly 12 digits")
	@Column(unique = true)
	private String cadharno;
	
	@ManyToOne(cascade =CascadeType.ALL)
	private Admin_Model admin_Model;
	
	@ManyToMany(mappedBy = "customer_Model")
	private List<Hotel_Model> hotel_Model;

	public Customer_Model(Long cid, String cname, String cnumber, String cadharno) {
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
	
	
	
	
}