package com.project.service;

import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;

public interface Customer_Service {
	
	public Customer_dto cust_to_dto(Customer_Model customer);
	public Customer_dto Register(Customer_Model customer);
	public String Delete(Long cid);
	public Customer_Model Update(Long cid,Customer_Model model);

}
