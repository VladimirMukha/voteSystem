package service;

import model.Restaurant;
import model.User;

import java.util.List;

public interface UserService {
    void delete(Integer id);

    User get(Integer id);

    User add(User user);

    List<User> getAll();

    User update(User user);

    void vote(Restaurant restaurant, Integer loggingUserId);
}
