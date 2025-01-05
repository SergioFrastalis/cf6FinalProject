package gr.aueb.cf.cf6finalproject.service;

import gr.aueb.cf.cf6finalproject.entity.Food;
import gr.aueb.cf.cf6finalproject.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }
}
