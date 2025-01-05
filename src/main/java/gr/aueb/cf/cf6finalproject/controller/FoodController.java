package gr.aueb.cf.cf6finalproject.controller;

import gr.aueb.cf.cf6finalproject.entity.Food;
import gr.aueb.cf.cf6finalproject.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Tag(name = "Food", description = "Endpoints for managing food")
@Controller
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Operation(summary = "Get all foods", description = "Retrieve a list of all foods")
    @GetMapping("/foods")
    public String getAllFoods(Model model) {
        List<Food> foods = foodService.findAllFoods();
        System.out.println("Fetched Foods: " + foods);
        model.addAttribute("foods", foods);
        return "foods";
    }

    @Operation(summary = "Get food details", description = "Retrieve details of a specific food")
    @GetMapping("/foods/details")
    public String getFoodDetails(@RequestParam("food") Long foodId, Model model) {
        Food food = foodService.findById(foodId);
        model.addAttribute("selectedFood", food);
        model.addAttribute("foods", foodService.findAllFoods());
        model.addAttribute("selectedFoodId", foodId);

        return "foods";
    }

    @GetMapping("/api/foods")
    @ResponseBody
    public List<Food> getAllFoodsAsJson() {
        return foodService.findAllFoods();
    }

}
