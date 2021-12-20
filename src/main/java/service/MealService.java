package service;

import model.Meal;

import java.util.List;

public interface MealService {
    Meal add(Meal meal, Integer uid);

    void delete(Integer id, Integer uid);

    Meal get(Integer id, Integer uid);

    List<Meal> getAll(Integer uid);

    Meal addRestaurantToId(Meal meal, Integer uid);
}
