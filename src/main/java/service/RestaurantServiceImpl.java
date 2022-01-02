package service;

import model.Meal;
import model.Restaurant;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;

    @Autowired
    RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant add(Restaurant restaurant) {
        Assert.notNull(restaurant, "ошибка! объект не найден.");
        repository.saveAndFlush(restaurant);
        return restaurant;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Restaurant get(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getAllVotedUsers(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant  must not by null");
        return repository.getById(restaurant.getId()).getUserList();
    }

    @Transactional
    public List<Meal> getMenuForRestaurant(Restaurant restaurant) {
        Assert.notNull(restaurant, "ресторан не найден!!!");
        return repository.getById(restaurant.getId()).getMenu().stream().collect(Collectors.toList());
    }
}
