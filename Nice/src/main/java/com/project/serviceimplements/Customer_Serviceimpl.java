package com.project.serviceimplements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Customer_dto;
import com.project.models.Customer_Model;
import com.project.repository.CustomerRepository;
import com.project.service.Customer_Service;


@Service
public class Customer_Serviceimpl implements Customer_Service {



		
		@Autowired
		private CustomerRepository repo;
		
		@Override
		public Customer_dto cust_to_dto(Customer_Model customer) {
			
			Customer_dto dto=new Customer_dto();
			dto.setCid(customer.getCid());
			dto.setCname(customer.getCname());
			
			return dto;
		}
		
		@Override
		public Customer_dto Register(Customer_Model customer) {
			
			repo.save(customer);
			
			return cust_to_dto(customer);
		}
		@Override
		public String Delete(Long cid) {
			
			repo.deleteById(cid);
			return "Customer Deleted succesfully";
		}
		@Override
		public Customer_Model Update(Long cid,Customer_Model model) {
			
			Optional<Customer_Model> opt= repo.findById(cid);
			Customer_Model mod=new Customer_Model();
			
			if(opt.isPresent()) {
			
			mod.setCname(model.getCname());
			mod.setCnumber(model.getCnumber());
			mod.setCadharno(model.getCadharno());
			}
			return mod;
			
			
		}
		
		

	}
