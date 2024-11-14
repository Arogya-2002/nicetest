package com.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Customer_Model;

@Repository
public interface CustomerRepository extends JpaRepository<Customer_Model, Long>{

}