package serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Food;
import repository.FoodRepository;
import service.Food_Service;

@Service
public class FoodServiceImpl implements Food_Service {
	

	@Autowired
	private FoodRepository foodRepository;

	
	@Override
	public Food addfood(Food food) {
		return foodRepository.save(food);
	}
	@Override
	public void deletefood(Long fid) {
		foodRepository.deleteById(fid);
		
	}
	
	@Override
	public Food updateFood(Long fid,Food food) {
		Food f = foodRepository.findById(fid).orElseThrow(() -> new RuntimeException("not found"));
		f.setFname(food.getFname());
		f.setFcost(food.getFcost());
		return food;
		}
		
		
	}

