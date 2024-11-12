package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Hotel_Model;

public interface Hotel_Repository extends JpaRepository<Hotel_Model, Long>{

}
