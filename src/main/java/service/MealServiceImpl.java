package service;

import model.Meal;
import repository.MealRepository;
import repository.RestaurantRepository;

import java.util.List;

public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    public MealServiceImpl(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Meal add(Meal meal, Integer uid) {
        return null;
    }

    @Override
    public void delete(Integer id, Integer uid) {

    }

    @Override
    public Meal get(Integer id, Integer uid) {
        return null;
    }

    @Override
    public List<Meal> getAll(Integer uid) {
        return null;
    }

    @Override
    public Meal addRestaurantToId(Meal meal, Integer uid) {
        return null;
    }
}
