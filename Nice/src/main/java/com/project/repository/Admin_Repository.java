package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Admin_Model;

@Repository
public interface Admin_Repository extends JpaRepository<Admin_Model, Long> {

}
