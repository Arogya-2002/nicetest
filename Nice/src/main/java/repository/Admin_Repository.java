package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Admin_Model;

public interface Admin_Repository extends JpaRepository<Admin_Model, Long> {

}
