package gr.aueb.cf.cf6finalproject.repository;

import gr.aueb.cf.cf6finalproject.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
