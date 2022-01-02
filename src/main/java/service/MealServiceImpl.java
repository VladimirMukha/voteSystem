package service;

import model.Meal;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.MealRepository;
import repository.RestaurantRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Meal add(Meal meal, Integer rId) {
        Assert.notNull(meal, "Meal must not by null");
        if (meal.isNew() && meal.getRestaurant().getId() != null) {
            return null;
        }
        Meal newMeal = addRestaurantToId(meal, rId);
        mealRepository.save(newMeal);
        return meal;
    }

    @Override
    public void delete(Integer id, Integer rId) {
        assert (id > 0 && rId.equals(mealRepository.getById(id).getRestaurant().getId()));
        mealRepository.deleteById(id);
    }

    @Override
    public Meal get(Integer id, Integer rId) {
        assert (Objects.equals(rId, mealRepository.getById(id).getRestaurant().getId()));
        return mealRepository.getById(id);
    }

    @Override
    public List<Meal> getAll(Integer rId) {
        return restaurantRepository.getById(rId).getMenu().stream().collect(Collectors.toList());
    }

    @Override
    public Meal addRestaurantToId(Meal meal, Integer rId) {
        Restaurant restaurant = restaurantRepository.findById(rId).orElse(null);
        Assert.notNull(restaurant, "Meal must not by null");
        Assert.notNull(meal, "Meal must not by null");
        meal.setRestaurant(restaurant);
        return meal;
    }
}
