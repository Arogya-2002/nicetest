package com.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Hotel_Model;


public interface Hotel_Repository extends JpaRepository<Hotel_Model, Long>{

}
