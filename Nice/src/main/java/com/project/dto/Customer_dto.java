package com.project.dto;

public class Customer_dto {
	private Long cid;
	
	private String cname;

	public Customer_dto(Long cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Customer_dto() {
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
}
	
	
