package com.project.serviceimplements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.ApiResponse;
import com.project.dto.Customer_dto;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.repository.CustomerRepository;
import com.project.service.Customer_Service;


@Service
public class Customer_Serviceimpl implements Customer_Service {



		
		@Autowired
		private CustomerRepository repo;
		
		@Override
		public ResponseEntity<ApiResponse<Customer_dto>> cust_to_dto(Customer_Model customer) {
			
			Customer_dto dto=new Customer_dto();
			dto.setCid(customer.getCid());
			dto.setCname(customer.getCname());
			
			ApiResponse<Customer_dto> response = new ApiResponse<>(HttpStatus.OK.value(), "Customer created", dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		
		
		
		 // Register customer with ApiResponse
	    @Override
	    public ResponseEntity<ApiResponse<Customer_dto>> Register(Customer_Model customer) {
	        if (customer.getCnumber().length() < 10) {
	            throw new Mycustomexception("Phone number should contain 10 digits", HttpStatus.NOT_FOUND);
	        }
	        if (customer.getCadharno().length() < 12) {
	            throw new Mycustomexception("Adhar number should contain 12 digits", HttpStatus.NOT_FOUND);
	        }

	        repo.save(customer);
	        return cust_to_dto(customer);
	    }
		
	    // Delete customer with ApiResponse
	    @Override
	    public ResponseEntity<ApiResponse<String>> Delete(Long cid) {
	        if (repo.existsById(cid)) {
	            repo.deleteById(cid);
	            ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "Customer deleted successfully", null);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            throw new Mycustomexception("Customer with " + cid + " is not present", HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update customer with ApiResponse
	    @Override
	    public ResponseEntity<ApiResponse<Customer_Model>> Update(Long cid, Customer_Model model) {
	        Optional<Customer_Model> opt = repo.findById(cid);

	        if (opt.isPresent()) {
	            Customer_Model existingCustomer = opt.get();
	            existingCustomer.setCname(model.getCname());
	            existingCustomer.setCnumber(model.getCnumber());
	            existingCustomer.setCadharno(model.getCadharno());

	            Customer_Model updatedCustomer = repo.save(existingCustomer);
	            ApiResponse<Customer_Model> response = new ApiResponse<>(HttpStatus.OK.value(), "Customer updated successfully", updatedCustomer);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
	        }
	    }

	    // Get customer by ID with ApiResponse
	    public ResponseEntity<ApiResponse<Customer_dto>> Getcustomer(long cid) {
	        Optional<Customer_Model> obj = repo.findById(cid);

	        if (obj.isPresent()) {
	            Customer_Model model = obj.get();
	            Customer_dto dto = new Customer_dto();
	            dto.setCid(model.getCid());
	            dto.setCname(model.getCname());

	            ApiResponse<Customer_dto> response = new ApiResponse<>(HttpStatus.OK.value(), "Customer found", dto);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            throw new Mycustomexception("Cid is not present", HttpStatus.NOT_FOUND);
	        }
	    }

	    // Get all customers with ApiResponse
	    public ResponseEntity<ApiResponse<List<Customer_dto>>> getcustomers() {
	        List<Customer_Model> customers = repo.findAll();

	        List<Customer_dto> customerDtos = customers.stream().map(customer -> {
	            Customer_dto dto = new Customer_dto();
	            dto.setCid(customer.getCid());
	            dto.setCname(customer.getCname());
	            return dto;
	        }).collect(Collectors.toList());

	        ApiResponse<List<Customer_dto>> response = new ApiResponse<>(HttpStatus.OK.value(), "Customer list retrieved successfully", customerDtos);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	}