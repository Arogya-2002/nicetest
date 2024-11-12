package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
