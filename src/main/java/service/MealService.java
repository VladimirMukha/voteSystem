package service;

import model.Meal;

import java.util.List;

public interface MealService {
    Meal add(Meal meal, Integer rId);

    void delete(Integer id, Integer rId);

    Meal get(Integer id, Integer rId);

    List<Meal> getAll(Integer rId);

    Meal addRestaurantToId(Meal meal, Integer rId);
}
